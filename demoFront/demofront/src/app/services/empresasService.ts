import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environment';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  private Url = environment.apiUrl + environment.endpointEmpresa;

  constructor(
    private httpClient: HttpClient
  ) { }

  getAll() {
    return this.httpClient.get(this.Url);
  }

  getById(idEmpresa: number) {
    return this.httpClient.get(`${this.Url}/${idEmpresa}`);
  }

  post(empresa: any) {
    return this.httpClient.post(this.Url, empresa);
  }

  put(empresa: any) {
    return this.httpClient.put(this.Url, empresa);
  }

  delete(idEmpresa: number) {
    return this.httpClient.delete(`${this.Url}/${idEmpresa}`);
  }
}
