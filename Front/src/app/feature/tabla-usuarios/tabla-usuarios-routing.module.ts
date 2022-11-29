import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TablaComponent } from './componentes/tabla/tabla.component';

const routes: Routes = [
  { path: '', component: TablaComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TablaUsuarioRoutingModule { }
