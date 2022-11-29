import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Phone } from '../../shared/model/tabla';

@Component({
  selector: 'app-modal-telefonos',
  templateUrl: './modal-telefonos.component.html',
  styleUrls: ['./modal-telefonos.component.css']
})
export class ModalTelefonosComponent implements OnInit {

  @Input() numeros: Phone[] = [];
  @Output() closeModal = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  public cerrarModal(): void {
    this.closeModal.emit();
  }

}
