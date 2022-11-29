import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Filtro } from '../../shared/model/tabla';

@Component({
  selector: 'app-filtro-tabla',
  templateUrl: './filtro-tabla.component.html',
  styleUrls: ['./filtro-tabla.component.css']
})
export class FiltroTablaComponent implements OnInit {

  @Output() busqueda = new EventEmitter<Filtro>;
  public filtros: FormGroup = new FormGroup([], null, null);

  constructor(
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.initForm();
    this.crearSubscripcion();
  }

  public initForm() {
    this.filtros = new FormGroup({
      name: new FormControl(''),
      email: new FormControl(''),
      startDate: new FormControl(''),
      endDate: new FormControl('')
    });
  }

  public crearSubscripcion() {
    this.filtros.get('startDate')?.valueChanges.subscribe((dateInicial: any) => {
      if (dateInicial !== '') {
        this.filtros.get('endDate')?.addValidators(Validators.required);
      } else {
        this.filtros.get('endDate')?.clearValidators();
      }
      this.filtros.get('endDate')?.setValue('', { emitEvent: true });
    })
  }

  public enviarFiltros(filtros: FormGroup) {
    this.busqueda.emit(this.filtros?.value);
  }

  public errores(campo: string): any {
    return this.filtros.get(campo)?.errors;
  }
}
