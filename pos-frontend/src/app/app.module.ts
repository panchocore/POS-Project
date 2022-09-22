import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaProductosComponent } from './lista-productos/lista-productos.component';
import { RegistrarProductoComponent } from './registrar-producto/registrar-producto.component';
import { ActualizarProductoComponent } from './actualizar-producto/actualizar-producto.component';
import { ProductoDetallesComponent } from './producto-detalles/producto-detalles.component';
import { DetalleComponent } from './detalle/detalle.component';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { ListaCabeceraComponent } from './lista-cabecera/lista-cabecera.component';

import { DetailComponent } from './detail/detail.component';
import { FacturaComponent } from './factura/factura.component';

@NgModule({
  declarations: [
    AppComponent,
    ListaProductosComponent,
    RegistrarProductoComponent,
    ActualizarProductoComponent,
    ProductoDetallesComponent,
    DetalleComponent,
    CabeceraComponent,
    ListaCabeceraComponent,
    DetailComponent,
    FacturaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
