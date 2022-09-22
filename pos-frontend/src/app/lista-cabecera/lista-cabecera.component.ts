import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cabecera } from '../cabecera';
import { CabeceraService } from '../cabecera.service';

@Component({
  selector: 'app-lista-cabecera',
  templateUrl: './lista-cabecera.component.html',
  styleUrls: ['./lista-cabecera.component.css']
})
export class ListaCabeceraComponent implements OnInit {

  cabeceras: Cabecera[];

  constructor(private CabeceraService:CabeceraService, private router:Router) { }

  ngOnInit(): void {
    this.obtenerCabeceras();
  }

  private obtenerCabeceras(){
    this.CabeceraService.obtenerlistaCabecera().subscribe(dato =>{
      this.cabeceras = dato;
    });
  }

}
