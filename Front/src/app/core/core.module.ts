import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { AlertaComponent } from './alerta/alerta.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';

@NgModule({
  declarations: [
    NavbarComponent,
    SidebarComponent,
    AlertaComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
  ],
  exports: [
    NavbarComponent,
    SidebarComponent,
    AlertaComponent,
    FooterComponent
  ],
  providers: [],
})
export class CoreModule { }
