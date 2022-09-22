import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from './producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private baseURL = "http://localhost:8181/productos/listar";
  private baseURL1 = "http://localhost:8181/productos/crear";
  private baseURL2 = "http://localhost:8181/productos/update";
  private baseURL3 = "http://localhost:8181/productos/producto"; 
  private baseURL4 = "http://localhost:8181/productos/eliminar"; 

  constructor(private httpClient : HttpClient) { }

  obtenerlistaProductos():Observable<Producto[]>{
    return this.httpClient.get<Producto[]>(this.baseURL);
  }
  
  guardarProducto(producto:Producto) : Observable<object>{
    return this.httpClient.post(this.baseURL1, producto);
  }

  actualizarProducto(id:number,producto:Producto) : Observable<Object>{
    return this.httpClient.put(this.baseURL2 + "/" + id, producto);
  }

  obtenerProductoPorId(id:number):Observable<Producto>{
    return this.httpClient.get<Producto>(this.baseURL3+"/"+id);
  }

  eliminarProducto(id:number):Observable<Object>{
    return this.httpClient.delete(this.baseURL4 + "/" + id);
  }
}
