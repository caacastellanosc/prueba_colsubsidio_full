import { Component, OnInit } from '@angular/core';
import { Phone, ConsultaTodos, User, Mensaje, Filtro } from '../../shared/model/tabla';
import { TablaService } from '../../shared/service/tabla.service';
@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class TablaComponent implements OnInit {

  public usuarios: User[] = [];
  public telefonos: Phone[] = [];
  public mostrarRegistro: boolean = false;
  public carga: boolean = false;
  public mensajeAlerta: Mensaje = {
    mensaje: '',
    codigo: 0
  };

  public filtros: Filtro = {
    name: '',
    email: '',
    startDate: '',
    endDate: '',
  };

  constructor(
    private readonly tablaService: TablaService
  ) { }

  ngOnInit(): void {
    this.consultarUsuarios();

  }

  public consultarUsuarios(): void {
    this.usuarios = [];
    this.carga = true;
    this.tablaService.consultaUsuarios(this.filtros).subscribe(
      {
        next: ((consulta: ConsultaTodos) => {
          this.usuarios = consulta.body;
        }),
        error: (e) => {
          this.mensajeAlerta.mensaje = 'Ha ocurrido un error con el sevidor, inténta mas tarde';
          this.mensajeAlerta.codigo = 404;
        },
        complete: () => {
          setTimeout(() => {
            this.carga = false;
          }, 1000);
        }
      });
  }

  public openModal(telefonos: Phone[]): void {
    this.telefonos = telefonos;
  }

  public closeModal(): void {
    this.telefonos = [];
  }

  public agregarUsuario(): void {
    this.mostrarRegistro = !this.mostrarRegistro;
  }

  public cerrarAlerta(): void {
    this.mensajeAlerta.mensaje = '';
    this.mensajeAlerta.codigo = 0;
  }

  public actualizarTabla(): void {
    this.mensajeAlerta.mensaje = 'Se ha registrado correctamente el usuario';
    this.mensajeAlerta.codigo = 200;
    this.agregarUsuario();
    this.consultarUsuarios();
  }

  public busquedaFiltrada(filtros: Filtro): void {
    this.filtros = filtros;
    this.consultarUsuarios();
  }
}
