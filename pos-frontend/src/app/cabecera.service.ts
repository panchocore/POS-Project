import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cabecera } from './cabecera';

@Injectable({
  providedIn: 'root'
})
export class CabeceraService {

  private baseURL = "http://localhost:8181/header/listar";
  private baseURL1 = "http://localhost:8181/header/crear";

  constructor(private httpClient : HttpClient) { }

  obtenerlistaCabecera():Observable<Cabecera[]>{
    return this.httpClient.get<Cabecera[]>(this.baseURL);
  }
  
  guardarCabecera(cabecera:Cabecera) : Observable<object>{
    return this.httpClient.post(this.baseURL1, cabecera);
  }
}
