import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
import { catchError} from 'rxjs/operators';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {

  facturas:any[];
  cargar:boolean = false;
  
  constructor(private hhtp:HttpClient) { }

  ngOnInit(): void {
    this.buscarFacturas();
  }

  buscarFacturas(){
    this.cargar = true;
    this.buscarFacturasServicio().subscribe(
      (response:any) => this.mostrarFacturas(response)
    )
  }

  mostrarFacturas(response:any){
    this.cargar = false;
    this.facturas = response;
  }

  buscarFacturasServicio():Observable<any>{
    return this.hhtp.get<any>("http://localhost:8181/factura/buscar").pipe(
      catchError(e=>"error") 
    );
  }

  eliminar(factura:any){
    this.cargar = true;
    this.eliminarFacturasServicio(factura.hdr_id).subscribe(
      (response:any) => this.buscarFacturas()
    )
  }

  eliminarFacturasServicio(id:any):Observable<any>{
    return this.hhtp.delete<any>("http://localhost:8181/factura/eliminar/" + id).pipe(
      catchError(e=>"error")
    )
  }

  agregar(){
    location.href="/crear";
  }
}
