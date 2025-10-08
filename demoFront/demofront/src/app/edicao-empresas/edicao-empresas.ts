import { Component, OnInit } from '@angular/core';
import { EmpresasService } from '../services/empresasService';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edicao-empresas',
  imports: [
    ReactiveFormsModule,
    FormsModule,
    RouterModule,
    CommonModule
  ],
  templateUrl: './edicao-empresas.html',
  styleUrl: './edicao-empresas.css'
})
export class EdicaoEmpresas implements OnInit {
  formEdicao: FormGroup;
  mensagem_sucesso?: string;
  mensagem_erro?: string;

  constructor(
    private fb: FormBuilder,
    private service: EmpresasService,
    private activatedRoute: ActivatedRoute
  ) {
    this.formEdicao = this.fb.group({
      id: [null],
      nomeFantasia: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      razaoSocial: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      cnpj: ['', [Validators.required, Validators.minLength(14), Validators.maxLength(14)]]
    });
  }

  get nomeFantasia() {
    return this.formEdicao?.get('nomeFantasia');
  }

  get razaoSocial() {
    return this.formEdicao?.get('razaoSocial');
  }

  get cnpj() {
    return this.formEdicao?.get('cnpj');
  }

  get form(): any {
    return this.formEdicao?.controls;
  }

  ngOnInit(): void {
    const idParam = this.activatedRoute.snapshot.paramMap.get('idEmpresa');    
    const idEmpresa = idParam ? Number(idParam) : null;

    if (idEmpresa && !isNaN(idEmpresa)) {
      this.service.getById(idEmpresa).subscribe({
        next: (empresa: any) => {
          const dados = empresa.empresaRequest ?? empresa;
          this.formEdicao.patchValue({
            id: dados.idEmpresa ?? dados.id,
            nomeFantasia: dados.nomeFantasia,
            razaoSocial: dados.razaoSocial,
            cnpj: dados.cnpj
          });
        },
        error: (e) => console.error('Erro ao carregar empresa:', e)
      });
    } else {
      console.error('ID da empresa inválido:', idParam);
    }
  }

  onSubmit() {
    this.service.put(this.formEdicao.value)
      .subscribe({
        next: (data: any) => {
          this.mensagem_sucesso = data.mensagem;
          this.mensagem_erro = "";
        },
        error: (e: any) => {
          this.mensagem_erro = e.mensagem;
          this.mensagem_sucesso = "";
        }
      }

      )
  }
}
