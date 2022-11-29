import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ConsultaTodos, Mensaje, Phone, RegisterUser } from '../../shared/model/tabla';
import { TablaService } from '../../shared/service/tabla.service';
import * as $ from 'jquery';
import { TokenService } from 'src/app/shared/token.service';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {

  @Output() cerrarRegistro = new EventEmitter();
  @Output() actualizarTabla = new EventEmitter();
  public form: FormGroup = new FormGroup([], null, null);
  public formItems: FormArray | undefined;
  public mensajeAlerta: Mensaje = {
    mensaje: '',
    codigo: 0
  };
  public totalTelefonos: number = 0;

  constructor(
    private fb: FormBuilder,
    private readonly tablaService: TablaService,
    public tokenService: TokenService
  ) { }

  ngOnInit(): void {
    this.initForm();
  }

  public initForm(): void {
    this.form = this.fb.group({
      name: [
        null,
        [
          Validators.required,
          Validators.pattern('[a-zA-Z ]{2,254}')
        ]
      ],
      email: [
        null,
        [
          Validators.required,
          Validators.email,
          Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')
        ]
      ],
      password: [
        null,
        [
          Validators.required,
        ]
      ],
      phones: this.fb.array([]),
    });
    this.agregarTelefono();
  }

  public agregarTelefono(): void {
    let formItems = this.form.get('phones') as FormArray;
    if (formItems.length < 2) {
      formItems.push(this.telefono());
    } else {
      this.mensajeAlerta.mensaje = 'Solo se permiten 2 números de teléfono';
      this.mensajeAlerta.codigo = 500;
    }
    this.totalTelefonos = formItems.length;
  }

  public telefono(): FormGroup {
    return this.fb.group({
      number: new FormControl('', [Validators.pattern('^[0-9]{0,16}$')]),
      cityCode: '',
      contryCode: ''
    })
  }

  listaTelefonosget(n: number): Array<number> {
    return Array(n);
  }

  public errores(campo: string): any {
    return this.form.get(campo)?.errors;
  }

  public cerrarAlerta(): void {
    this.mensajeAlerta.mensaje = '';
    this.mensajeAlerta.codigo = 0;
  }

  public guardar(formulario: FormGroup): void {
    this.tablaService.registrarUsuario(formulario.value).subscribe(
      {
        next: ((consulta: RegisterUser) => {
          switch (consulta.code) {
            case 200:
              this.tokenService.saveTheme(consulta.body.token!);
              this.actualizarTabla.emit();
              break;
            default:
              this.mensajeAlerta.mensaje = 'La contraseña no tiene los caracteres adecuados';
              this.mensajeAlerta.codigo = consulta.code;
              break;
          }
        }),
        error: (e) => {
          this.mensajeAlerta.mensaje = 'Ha ocurrido un error con el sevidor, inténta mas tarde';
          this.mensajeAlerta.codigo = 404;
        },
        complete: () => console.info('complete')
      }
    )
  }

}
