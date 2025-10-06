import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { AuthModel } from '../util/models/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationHelper {

  private KEY: string = "USER_AUTH";

  // BehaviorSubject mantém o estado atual do usuário
  private authSubject: BehaviorSubject<AuthModel | null>;

  // Observable público que os componentes vão assinar
  public auth$: Observable<AuthModel | null>;

  constructor() {
    // Inicializa com o valor do localStorage (ou null se não tiver)
    const storedAuth = this.getAuthFromStorage();
    this.authSubject = new BehaviorSubject<AuthModel | null>(storedAuth);
    this.auth$ = this.authSubject.asObservable();
  }

  // Login: salva no storage e notifica todos os assinantes
  signIn(auth: AuthModel): void {
    localStorage.setItem(this.KEY, JSON.stringify(auth));
    this.authSubject.next(auth);
  }

  // Logout: remove do storage e notifica assinantes
  signOut(): void {
    localStorage.removeItem(this.KEY);
    this.authSubject.next(null);
  }

  // Retorna o valor atual do BehaviorSubject (não precisa parsear sempre)
  getAuth(): AuthModel | null {
    return this.authSubject.value;
  }

  // Checa se o usuário está logado
  isLoggedIn(): boolean {
    return !!this.getAuth();
  }

  // Função auxiliar para ler o storage ao inicializar
  private getAuthFromStorage(): AuthModel | null {
    const data = localStorage.getItem(this.KEY);
    return data ? JSON.parse(data) as AuthModel : null;
  }
}
