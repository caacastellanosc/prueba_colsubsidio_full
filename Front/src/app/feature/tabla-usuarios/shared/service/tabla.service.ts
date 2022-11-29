import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConsultaTodos, Filtro, RegisterUser, User } from '../model/tabla';
import { Observable } from 'rxjs';
import { enviroment } from 'src/environments/environments.prod';

@Injectable({
  providedIn: 'root'
})
export class TablaService {

  urlConsultaUsuarios: string | undefined = 'usuario/parametros';
  urlRegistroUsuarios: string | undefined = 'usuario/registro';

  constructor(protected http: HttpClient) {
  }

  public consultaUsuarios(filtros: Filtro): Observable<ConsultaTodos> {
    return this.http.post<ConsultaTodos>(`${enviroment.API}/${this.urlConsultaUsuarios}`, filtros);
  }

  public registrarUsuario(user: User): Observable<RegisterUser> {
    return this.http.post<RegisterUser>(`${enviroment.API}/${this.urlRegistroUsuarios}`, user);
  }
}
