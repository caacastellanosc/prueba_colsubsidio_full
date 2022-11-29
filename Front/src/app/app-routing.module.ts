import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

const routes: Routes = [
  { path: '', redirectTo: '/tabla-usuarios', pathMatch: 'full' },
  {
    path: '',
    children: [
      {
        path: 'tabla-usuarios',
        loadChildren: () => import('./feature/tabla-usuarios/tabla-usuarios.module').then(mod => mod.TablaUsuarioModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
