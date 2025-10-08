import { Component, OnInit } from '@angular/core';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';
import { EmpresasService } from '../services/empresasService';
import { CommonModule, NgFor, NgIf, UpperCasePipe } from '@angular/common';
import { FuncionariosService } from '../services/funcionariosService';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastro-funcionarios',
  standalone: true,
  imports: [NgxMaskDirective, UpperCasePipe, NgFor, NgIf, ReactiveFormsModule, CommonModule, NgxMaskPipe],
  templateUrl: './cadastro-funcionarios.html',
  styleUrls: ['./cadastro-funcionarios.css'],
  providers: [provideNgxMask()]
})
export class CadastroFuncionarios implements OnInit {

  empresas: any[] = []
  mensagem_sucesso: string = ''
  mensagem_erro: string = ''
  formFuncionario: FormGroup

  constructor(
    private fb: FormBuilder,
    private empresasService: EmpresasService,
    private funcionariosService: FuncionariosService
  ) {
    this.formFuncionario = this.fb.group({
      nome: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(150)]],
      cpf: ['', [Validators.required]],
      dataAdmissao: ['', [Validators.required]],
      matricula: ['', [Validators.required]],
      idEmpresa: [null, Validators.required]
    });
  }

  ngOnInit(): void {
    this.obterEmpresas();
  }

  obterEmpresas(): void {
    this.empresasService.getAll()
      .subscribe({
        next: (data) => {
          this.empresas = data as any[]
        },
        error: (erro) => {
          console.log(erro)
        }
      });
  }

  get form(): any {
    return this.formFuncionario.controls
  }

  onSubmit(): void {
    this.mensagem_sucesso = ''
    this.mensagem_erro = ''
    this.funcionariosService.post(this.formFuncionario.value)
      .subscribe({
        next: (data: any) => {
          this.mensagem_sucesso = data.mensagem
          this.formFuncionario.reset();
        },
        error: (err) => {
          this.mensagem_erro = err.mensagem
        },
      })
  }


  get nome() {
    return this.formFuncionario.get('nome');
  }

  get cpf() {
    return this.formFuncionario.get('cpf')
  }

  get dataAdmissao() {
    return this.formFuncionario.get('dataAdmissao')
  }

  get matricula() {
    return this.formFuncionario.get('matricula')
  }

  get idEmpresa() {
    return this.formFuncionario.get('idEmpresa')
  }

}
