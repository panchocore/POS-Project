import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {

  cargar:boolean = false;
  factura:any = {detailList:[]};
  
  constructor() { }

  ngOnInit(): void {
  }

  consultar(){
    location.href = "/";
  }

  guardar(){

  }

  agregarProducto(){
    this.factura.detailList.push({});
  }

  eliminar(prod:any){
    this.factura.detailList.splice(this.factura.detailList.indexOf(prod),1);
  }
}
