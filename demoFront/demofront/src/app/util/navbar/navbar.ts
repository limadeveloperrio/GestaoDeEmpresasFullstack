import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { AuthenticationHelper } from '../../services/authenticationhelper';
import { NgIf } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, NgIf],
  templateUrl: './navbar.html',
  styleUrls: ['./navbar.css']
})
export class Navbar implements OnInit {

  isLoggedIn = false;
  nomeUsuario?: string;
  emailUsuario?: string;

  constructor(
    public auth: AuthService,
    public authHelper: AuthenticationHelper,
    private router: Router
  ) { }

  ngOnInit() {
    this.authHelper.auth$.subscribe(auth => {
      this.isLoggedIn = !!auth;
      this.nomeUsuario = auth?.nomeUsuario || '';
      this.emailUsuario = auth?.email || '';
    });
  }

  logout(): void {
    this.authHelper.signOut();
    this.router.navigate(['/login']); // ← redireciona após logout
  }

}
