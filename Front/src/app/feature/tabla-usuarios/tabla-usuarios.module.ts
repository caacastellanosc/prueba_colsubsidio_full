import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CoreModule } from 'src/app/core/core.module';
import { FiltroTablaComponent } from './componentes/filtro-tabla/filtro-tabla.component';
import { ModalTelefonosComponent } from './componentes/modal-telefonos/modal-telefonos.component';
import { RegistroUsuarioComponent } from './componentes/registro-usuario/registro-usuario.component';
import { TablaComponent } from './componentes/tabla/tabla.component';
import { TablaService } from './shared/service/tabla.service';
import { TablaUsuarioRoutingModule } from './tabla-usuarios-routing.module';

@NgModule({
  declarations: [
    TablaComponent,
    FiltroTablaComponent,
    ModalTelefonosComponent,
    RegistroUsuarioComponent
   ],
  imports: [
    TablaUsuarioRoutingModule,
    CommonModule,
    HttpClientModule,
    FormsModule, 
    ReactiveFormsModule,
    CoreModule,
  ],
  exports: [
  ],
  providers: [
    HttpClient,
    TablaService
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TablaUsuarioModule { }
