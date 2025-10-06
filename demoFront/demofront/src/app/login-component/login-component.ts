import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationHelper } from '../services/authenticationhelper';
import { AuthService } from '../services/auth.service';
import { NgIf } from '@angular/common';
import { Router } from '@angular/router';
import { AuthModel } from '../util/models/auth';


@Component({
  selector: 'app-login-component',
  imports: [ReactiveFormsModule, NgIf],
  templateUrl: './login-component.html',
  styleUrl: './login-component.css'
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup
  mensagem: string = ''

  constructor(
    private fb: FormBuilder,
    private authhelper: AuthenticationHelper,
    private authService: AuthService,
    private router: Router
  ) {
    this.formLogin = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {

  }

  onSubmit(): void {
    if (this.formLogin.invalid) {
      this.mensagem = 'Preencha todos os campos obrigatórios';
      return;
    }
    this.mensagem = ''
    console.log(this.formLogin.value)

    this.authService.login(this.formLogin.value).subscribe({
      next: (data: any) => {
        this.authhelper.signIn(data as AuthModel);
        this.router.navigate(['/inicio']);
      },
      error: (error: any) => {
        this.mensagem = error.error?.message || 'Erro ao fazer login';
      }
    });
  }


  get form(): any {
    return this, this.formLogin.controls
  }

  get email() {
    return this.formLogin.get('email');
  }

  get senha() {
    return this.formLogin.get('senha')
  }
  
}
