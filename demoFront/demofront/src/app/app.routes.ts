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
    path: 'edicao-empresa/:idEmpresa',
    canActivate: [authGuard],
    loadComponent: () => import('./edicao-empresas/edicao-empresas')
      .then(m => m.EdicaoEmpresas)
  },
  {
    path: 'cadastro-funcionarios',
    canActivate: [authGuard],
    loadComponent: () => import('./cadastro-funcionarios/cadastro-funcionarios')
      .then(m => m.CadastroFuncionarios)
  },
  {
    path: 'consulta-funcionarios',
    canActivate: [authGuard],
    loadComponent: () => import('./consulta-funcionarios/consulta-funcionarios')
      .then(m => m.ConsultaFuncionarios)
  }, {
    path: 'edicao-funcionarios',
    canActivate: [authGuard],
    loadComponent: () => import('./edicao-funcionarios/edicao-funcionarios')
      .then(m => m.EdicaoFuncionarios)
  },
  {
    path: '',
    redirectTo: '/inicio',
    pathMatch: 'full'
  }
];

