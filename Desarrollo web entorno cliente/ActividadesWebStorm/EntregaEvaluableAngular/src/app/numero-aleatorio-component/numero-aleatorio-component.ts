import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-numero-aleatorio',
  imports: [FormsModule],
  templateUrl: './numero-aleatorio-component.html',
  styleUrl: './numero-aleatorio-component.css',
})
export class NumeroAleatorioComponent {
  minimo: number = 1;
  maximo: number = 10;
  cantidad: number = 5;
  repetidos: boolean = false;

  numeross: number[] = [];
  mensaje: string = '';

  generarNumeros() {
    this.numeross = [];
    this.mensaje = '';

    if (!Number.isInteger(this.minimo) || !Number.isInteger(this.maximo)) {
      this.mensaje = 'El mínimo y el máximo deben ser números enteros.';
      return;
    }

    if (this.minimo > this.maximo) {
      this.mensaje = 'El mínimo no puede ser mayor que el máximo.';
      return;
    }

    if (!Number.isInteger(this.cantidad) || this.cantidad < 1) {
      this.mensaje = 'La cantidad debe ser un entero mayor que 0.';
      return;
    }

    let posibles = this.maximo - this.minimo + 1;

    if (!this.repetidos && this.cantidad > posibles) {
      this.mensaje = `Error: sin repetidos solo se pueden extraer ${posibles} números entre ${this.minimo} y ${this.maximo}. Ajusta la cantidad o el rango.`;
      return;
    }

    while (this.numeross.length < this.cantidad) {
      let numero = Math.floor(Math.random() * posibles) + this.minimo;

      if (this.repetidos || !this.numeross.includes(numero)) {
        this.numeross.push(numero);
      }
    }
  }
}
