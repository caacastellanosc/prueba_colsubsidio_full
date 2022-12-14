import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  public getToken(): string  {
    return localStorage.getItem('TOKEN')!;
  }

  public saveTheme(token: string): void {
    localStorage.setItem('TOKEN', token);
  }

}
