import { Component, OnInit } from '@angular/core';
import { ObservableMenuService } from '../shared/service/observable-menu/observableMenu.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(private observableMenu: ObservableMenuService) { }

  ngOnInit(): void {
  }
}