import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationHelper } from './app/services/authenticationhelper';
import { environment } from './environment';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authHelper: AuthenticationHelper) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const auth = this.authHelper.getAuth();
    const token = auth?.token;

    // Verifica se a requisição é para o endpoint de login
    const isLoginRequest = req.url === environment.apiUrl + environment.endpointlogin;

    // Se não for login e tiver token, adiciona Authorization
    const authReq = (!isLoginRequest && token)
      ? req.clone({ setHeaders: { Authorization: `Bearer ${token}` } })
      : req;

    return next.handle(authReq);
  }
}
