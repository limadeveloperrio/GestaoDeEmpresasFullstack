import { Injectable } from '@angular/core';
import { environment } from '../../environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FuncionariosService {

  endpoint: string = environment.apiUrl + environment.endpointfuncionario;

  constructor(
    private httpClient: HttpClient
  ){}
  
  post(funcionario: any){
    return this.httpClient.post(this.endpoint, funcionario);
  }
}
