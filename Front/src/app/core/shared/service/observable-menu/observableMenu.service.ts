import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ObservableMenuService {

  nombre$ = new EventEmitter<Boolean>();

  constructor() { }

}
