import { Routes } from '@angular/router';
import { authGuard } from './services/auth.guard';

export const routes: Routes = [
  {
    path: 'login',
    loadComponent: () => import('./login-component/login-component')
      .then(m => m.LoginComponent)
  },
  {
    path: 'inicio',
    canActivate: [authGuard],
    loadComponent: () => import('./pagina-inicial/pagina-inicial')
      .then(m => m.PaginaInicial)
  },
  {
    path: 'cadEmpresa',
    canActivate: [authGuard],
    loadComponent: () => import('./cadastro-empresas/cadastro-empresa')
      .then(m => m.CadastroEmpresas)
  },
  {
    path: 'consultar',
    canActivate: [authGuard],
    loadComponent: () => import('./consulta-empresas/consulta-empresas')
      .then(m => m.ConsultaEmpresas)
  },
  {
    path: 'edicao-empresa/:id',
    canActivate: [authGuard],
    loadComponent: () => import('./edicao-empresas/edicao-empresas')
      .then(m => m.EdicaoEmpresas)
  },
  {
    path: '', 
    redirectTo: '/inicio',
    pathMatch: 'full'
  }
];

