import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  cargar:boolean = false;
  factura:any = {detailList:[]};
  
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  consultar(){
    location.href = "/";
  }

  guardar(){
    let formulario:any = document.getElementById("formulario");
    if(formulario.reportValidity()){
      this.cargar = true;
      this.factura.hdr_date = new Date();
      this.factura.hdr_total = 0;
      for(let i = 0; i < this.factura.detailList.length; i++){
        this.factura.hdr_total += this.factura.detailList[i].dtl_subtotal;
      }
      this.servicioGuardar().subscribe(
        (response:any) => this.resultadoServicio(response)
      )
    }

  }

  resultadoServicio(res:any){
    this.cargar = false;
    this.factura = {detailList:[]};
    alert("Factura guardada con id: " + res.hdr_id);
  }

  agregarProducto(){
    this.factura.detailList.push({});
  }

  eliminar(prod:any){
    this.factura.detailList.splice(this.factura.detailList.indexOf(prod),5);
  }

  servicioGuardar(){
    var httpOptions = {
      headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

    return this.http.post<any>("http://localhost:8181/factura/guardar", this.factura, httpOptions).pipe(
      catchError(e=>'error')
    )
  }

}
