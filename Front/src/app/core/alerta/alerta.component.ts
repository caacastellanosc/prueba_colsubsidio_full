import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Mensaje } from 'src/app/feature/tabla-usuarios/shared/model/tabla';

@Component({
  selector: 'app-alerta',
  templateUrl: './alerta.component.html',
  styleUrls: ['./alerta.component.css']
})
export class AlertaComponent implements OnInit {
  @Input() mensajeAlerta: Mensaje = {
    mensaje: '',
    codigo: 0
  };
  @Output() cerrarAlerta = new EventEmitter;

  constructor() { }

  ngOnInit() {
    setTimeout(() => {
      this.cerrarAlerta.emit();
    }, 20000);
  }

  colorAlerta() {
    switch (this.mensajeAlerta.codigo) {
      case 200:
        return 'alert-success';
      case 500:
        return 'alert-warning';
      case 404:
        return 'alert-danger';
      default:
        return 'alert-warning';
    }
  }
}
