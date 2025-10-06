import { Component, OnInit } from '@angular/core';
import { EmpresasService } from '../services/empresasService';
import { NgFor, UpperCasePipe } from '@angular/common';
import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-consulta-empresas',
  standalone: true,
  imports: [
    UpperCasePipe,
    NgxPaginationModule,
    NgFor,
    FormsModule,
    RouterLink,
],
  templateUrl: './consulta-empresas.html',
  styleUrl: './consulta-empresas.css'
})
export class ConsultaEmpresas implements OnInit {

  empresas: any[] = [];
  pagina = 1;
  currentPage = 1;
  itemsPerPage = 10;
  searchText: string = '';

  mensagem_sucesso = "";
  mensagem_erro = "";

  constructor(private service: EmpresasService) { }

  ngOnInit(): void {
    this.service.getAll()
      .subscribe({
        next: (data: any) => {
          console.log(data);
          this.empresas = data as any[];
        },
        error: (e: any) => {
          console.log(e);
        }
      });
  }

handlePageChange(event: number): void {
  this.currentPage = event;
}

  get empresasPaginadas() {
    const start = (this.currentPage - 1) * this.itemsPerPage;
    return this.empresas.slice(start, start + this.itemsPerPage);
  }

  get empresasFiltradas() {
  return this.empresas.filter(e =>
    e.nomeFantasia.toLowerCase().includes(this.searchText?.toLowerCase() || '') ||
    e.razaoSocial.toLowerCase().includes(this.searchText?.toLowerCase() || '')
  );
}

  excluir(id: number): void {
    if (window.confirm("Deseja realmente excluir a empresa selecionada?")) {
      this.service.delete(id).subscribe({
        next: (data: any) => {
          this.mensagem_sucesso = data.mensagem; 
          this.mensagem_erro = "";       
          this.ngOnInit();
        },
        error: (e: any) => {
          this.mensagem_erro = e.error.mensagem;
          this.mensagem_sucesso = "";
        }
      });
    }
  }

  onSubmit(){

  }
}
