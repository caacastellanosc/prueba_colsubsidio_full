import { Component, OnInit } from '@angular/core';
import { observable } from 'rxjs';
import { ObservableMenuService } from '../shared/service/observable-menu/observableMenu.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private observableMenu: ObservableMenuService) { }

  ngOnInit(): void {
  }

  public menu(): void {
    this.observableMenu.nombre$.emit(true);
  }
}
