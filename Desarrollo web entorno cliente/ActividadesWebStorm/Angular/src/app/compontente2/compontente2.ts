import { Component } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-compontente2',
  styleUrl: './compontente2.css',
  templateUrl: './compontente2.html',
})
export class Compontente2 {
  saludo: string='';
  constructor() {
    this.generarSaludo();
  }
  generarSaludo() {
    const hora= new Date().getHours();
    if (hora<12){
      this.saludo = 'Buenos dias'
    }else if(hora<20){
      this.saludo = 'Buenas tardes'
    }else {
      this.saludo = 'Buenas noches'
    }
  }
}
