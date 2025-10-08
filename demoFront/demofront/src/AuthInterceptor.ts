import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';
import { AuthenticationHelper } from './app/services/authenticationhelper';
import { environment } from './environment';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private authHelper: AuthenticationHelper,
    private router: Router
  ) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const auth = this.authHelper.getAuth();
    const token = auth?.token;

    // Verifica se é a requisição de login
    const isLoginRequest = req.url === environment.apiUrl + environment.endpointlogin;

    // Se não for login e tiver token, adiciona Authorization
    const authReq = (!isLoginRequest && token)
      ? req.clone({ setHeaders: { Authorization: `Bearer ${token}` } })
      : req;

    // Intercepta respostas de erro (ex: token expirado)
    return next.handle(authReq).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 401 || error.status === 403) {
          // Token expirado ou inválido → limpar e redirecionar
          this.authHelper.signOut();
          this.router.navigate(['/login']);
        }
        return throwError(() => error);
      })
    );
  }
}
