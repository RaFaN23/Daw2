import { Component, OnDestroy, signal } from '@angular/core';

@Component({
  selector: 'app-ventana-hija',
  imports: [],
  templateUrl: './ventana-hija-component.html',
  styleUrl: './ventana-hija-component.css',
})
export class VentanaHijaComponent implements OnDestroy {

  readonly desplazamiento = 100;

  private ventana: Window | null = null;
  abierta = signal(false);
  mensaje = signal('');

  private comprobacion: ReturnType<typeof setInterval> | null = null;

  abrir(): void {
    this.mensaje.set('');

    if (this.ventana && !this.ventana.closed) {
      this.mensaje.set('Ya hay una ventana abierta.');
      return;
    }

    this.ventana = window.open('', 'ventanaHija', 'width=400,height=400');

    if (!this.ventana) {
      this.mensaje.set('El navegador ha bloqueado la ventana emergente.');
      return;
    }

    this.abierta.set(true);

    this.comprobacion = setInterval(() => {
      if (!this.ventana || this.ventana.closed) {
        this.alCerrar();
      }
    }, 300);
  }

  mover(x: number, y: number): void {
    if (this.ventana && !this.ventana.closed) {
      this.ventana.moveBy(x, y);
      this.ventana.focus();
    }
  }

  cerrar(): void {
    if (this.ventana && !this.ventana.closed) {
      this.ventana.close();
    }
    this.alCerrar();
  }

  ngOnDestroy(): void {
    this.cerrar();
  }

  private alCerrar(): void {
    if (this.comprobacion) {
      clearInterval(this.comprobacion);
      this.comprobacion = null;
    }
    this.ventana = null;
    this.abierta.set(false);
  }
}
