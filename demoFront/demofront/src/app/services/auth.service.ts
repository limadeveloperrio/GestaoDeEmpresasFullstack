import { Injectable } from '@angular/core';
import { environment } from '../../environment';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

import { AuthenticationHelper } from './authenticationhelper';
import { AuthModel } from '../util/models/auth';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private Url = environment.apiUrl + environment.endpointlogin;

  constructor(
    private httpClient: HttpClient,
    private authHelper: AuthenticationHelper
  ) {}

  /**
   * Faz login chamando o backend
   */
  login(credentials: { email: string; senha: string }): Observable<AuthModel> {
    return this.httpClient.post<AuthModel>(this.Url, credentials).pipe(
      tap((response: AuthModel) => {
        // salva dados do usuário autenticado no localStorage
        this.authHelper.signIn(response);
      })
    );
  }

  /**
   * Faz logout local — remove os dados do usuário autenticado
   */
  logout(): void {
    this.authHelper.signOut();
  }

  /**
   * Retorna se o usuário está logado (com base no localStorage)
   */
  isLoggedIn(): boolean {
    return this.authHelper.isLoggedIn();
  }
}
