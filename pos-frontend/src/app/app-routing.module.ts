import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActualizarProductoComponent } from './actualizar-producto/actualizar-producto.component';
import { ListaCabeceraComponent } from './lista-cabecera/lista-cabecera.component';
import { ListaProductosComponent } from './lista-productos/lista-productos.component';
import { ProductoDetallesComponent } from './producto-detalles/producto-detalles.component';
import { RegistrarProductoComponent } from './registrar-producto/registrar-producto.component';


import { FacturaComponent } from './factura/factura.component'; 
import { DetailComponent } from './detail/detail.component';

const routes: Routes = [
  {path : 'productos', component:ListaProductosComponent},
  //{path: '', redirectTo:'productos',pathMatch:'full'},
  {path : 'registrar-producto', component : RegistrarProductoComponent},
  {path : 'actualizar-producto/:id', component : ActualizarProductoComponent},
  {path : 'ventas', component : ListaCabeceraComponent},
  
  {path: '', redirectTo:'facturas',pathMatch:'full'},
  {path : 'facturas', component: FacturaComponent},
  {path: 'crear', component:DetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
