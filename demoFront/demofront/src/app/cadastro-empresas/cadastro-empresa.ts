
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmpresasService } from '../services/empresasService';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';

@Component({
  selector: 'app-cadastro-empresas',
  standalone: true,
  templateUrl: './cadastro-empresa.html',
  styleUrls: ['./cadastro-empresa.css'],
  imports: [CommonModule, 
    ReactiveFormsModule,
    NgxMaskDirective, 
    ],
    providers: [provideNgxMask()] 
})
export class CadastroEmpresas {
  formcadastro: FormGroup;
  mensagem_sucesso?: string;
  mensagem_erro?: string;

  constructor(private fb: FormBuilder,
    private service: EmpresasService
  ) {
    this.formcadastro = this.fb.group({
      nomeFantasia: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      razaoSocial: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      cnpj: ['', [Validators.required, Validators.minLength(14), Validators.maxLength(14)]]
    });
  }

  get nomeFantasia() {
    return this.formcadastro.get('nomeFantasia');
  }

  get razaoSocial() {
    return this.formcadastro.get('razaoSocial');
  }

  get cnpj() {
    return this.formcadastro.get('cnpj');
  }

  onSubmit(): void {
    if (this.formcadastro.valid) {
      this.service.post(this.formcadastro.value).subscribe({
        next: (data: any) => {
          console.log("✅ Empresa cadastrada:", data);
          this.mensagem_sucesso = data.mensagem
          this.mensagem_erro = "";
          this.formcadastro.reset();
        },
        error: (err: any) => {
          console.error("❌ Erro ao cadastrar:", err);
          this.mensagem_erro = err.error.mensagem
          this.mensagem_sucesso = ""
        }
      });
    }
  }

  limparCampos() {
    this.formcadastro.reset();
  }
}
