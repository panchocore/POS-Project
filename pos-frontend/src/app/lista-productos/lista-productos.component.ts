import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-lista-productos',
  templateUrl: './lista-productos.component.html',
  styleUrls: ['./lista-productos.component.css']
})
export class ListaProductosComponent implements OnInit {

  productos:Producto[];

  constructor(private ProductoService:ProductoService, private router:Router) { }

  ngOnInit(): void {
    this.obtenerProductos();
  }

  private obtenerProductos(){
    this.ProductoService.obtenerlistaProductos().subscribe(dato =>{
      this.productos = dato;
    });
  }

  actualizarProducto(id:number){
    this.router.navigate(['actualizar-producto',id]);
  }

  eliminarProducto(id:number){
    this.ProductoService.eliminarProducto(id).subscribe(dato => {
      console.log(dato);
      this.obtenerProductos();
    });
  }

  
}
