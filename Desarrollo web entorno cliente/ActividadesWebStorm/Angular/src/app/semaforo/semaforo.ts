import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-semaforo',
  standalone: true,
  templateUrl: './semaforo.html',
  styleUrls: ['./semaforo.css']
})
export class Semaforo implements OnInit, OnDestroy {

  luzActiva: string = 'verde';
  segundos: number = 0;
  pausado: boolean = false;

  intervalo: ReturnType<typeof setInterval> | undefined;

  ngOnInit(): void {
    this.iniciarSemaforo();
  }

  iniciarSemaforo(): void {
    this.intervalo = setInterval(() => {

      this.segundos++;

      if (this.luzActiva === 'verde' && this.segundos >= 5) {
        this.luzActiva = 'ambar';
        this.segundos = 0;
      } else if (this.luzActiva === 'ambar' && this.segundos >= 2) {
        this.luzActiva = 'roja';
        this.segundos = 0;
      } else if (this.luzActiva === 'roja' && this.segundos >= 5) {
        this.luzActiva = 'verde';
        this.segundos = 0;
      }

    }, 1000);
  }

  detenerOReanudar(): void {

    if (this.intervalo !== undefined) {
      clearInterval(this.intervalo);
      this.intervalo = undefined;
      this.pausado = true;
    } else {
      this.pausado = false;
      this.iniciarSemaforo();
    }

  }

  ngOnDestroy(): void {

    if (this.intervalo !== undefined) {
      clearInterval(this.intervalo);
    }

  }

}
