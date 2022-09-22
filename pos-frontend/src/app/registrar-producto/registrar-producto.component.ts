import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';


@Component({
  selector: 'app-registrar-producto',
  templateUrl: './registrar-producto.component.html',
  styleUrls: ['./registrar-producto.component.css']
})
export class RegistrarProductoComponent implements OnInit {

  producto : Producto = new Producto();

  constructor(private productoServicio:ProductoService, private router:Router) { }

  ngOnInit(): void {
    
  }

  guardarProducto(){
    this.productoServicio.guardarProducto(this.producto).subscribe(dato =>{
      console.log(dato);
      this.goToListaProductos();
    }, error => console.log(error));
}

goToListaProductos(){
  this.router.navigate(['/productos']);
}

  onSubmit(){
    this.guardarProducto();
  }

}
