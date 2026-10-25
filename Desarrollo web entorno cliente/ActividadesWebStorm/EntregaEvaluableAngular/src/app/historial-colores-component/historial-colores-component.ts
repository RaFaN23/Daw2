import { Component, HostListener, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-historial-colores',
  imports: [FormsModule],
  templateUrl: './historial-colores-component.html',
  styleUrl: './historial-colores-component.css',
})
export class HistorialColoresComponent implements OnInit {

  colores = [
    { nombre: 'Blanco', valor: 'white' },
    { nombre: 'Rojo', valor: 'tomato' },
    { nombre: 'Verde', valor: 'lightgreen' },
    { nombre: 'Azul', valor: 'lightblue' },
    { nombre: 'Amarillo', valor: 'gold' },
    { nombre: 'Morado', valor: 'plum' }
  ];


  historial = signal<string[]>([]);
  posicion = signal(0);

  pasosRetroceso: number = 1;
  mensaje = signal('');

  ngOnInit(): void {

    const guardado = sessionStorage.getItem('historialColores');
    const lista: string[] = guardado ? JSON.parse(guardado) : [this.colores[0].valor];
    const paso = Number(new URLSearchParams(location.search).get('paso') ?? 0);

    this.historial.set(lista);

    if (Number.isInteger(paso) && paso >= 0 && paso < lista.length) {
      this.posicion.set(paso);
    } else {
      this.posicion.set(0);
    }

    this.guardarLista();
    history.replaceState({ paso: this.posicion() }, '', this.urlPaso(this.posicion()));
  }


  @HostListener('window:popstate')
  alCambiarHistorial(): void {
    const paso = Number(new URLSearchParams(location.search).get('paso') ?? 0);

    if (Number.isInteger(paso) && paso >= 0 && paso < this.historial().length) {
      this.posicion.set(paso);
    }
  }

  colorActual(): string {
    return this.historial()[this.posicion()];
  }

  nombreColor(valor: string): string {
    const color = this.colores.find(c => c.valor === valor);
    return color ? color.nombre : valor;
  }

  elegirColor(valor: string): void {
    this.mensaje.set('');

    if (valor === this.colorActual()) {
      return;
    }
    const nuevaLista = this.historial().slice(0, this.posicion() + 1);
    nuevaLista.push(valor);
    this.historial.set(nuevaLista);
    this.posicion.set(nuevaLista.length - 1);
    this.guardarLista();

    history.pushState({ paso: this.posicion() }, '', this.urlPaso(this.posicion()));
  }

  atras(): void {
    this.mensaje.set('');
    history.back();
  }

  adelante(): void {
    this.mensaje.set('');
    history.forward();
  }

  retroceder(): void {
    this.mensaje.set('');

    if (!Number.isInteger(this.pasosRetroceso) || this.pasosRetroceso < 1) {
      this.mensaje.set('Indica un número entero de cambios mayor que 0.');
      return;
    }

    if (this.pasosRetroceso > this.posicion()) {
      this.mensaje.set(`No es posible retroceder ${this.pasosRetroceso} cambios: solo puedes retroceder ${this.posicion()}.`);
      return;
    }

    history.go(-this.pasosRetroceso);
  }

  private guardarLista(): void {
    sessionStorage.setItem('historialColores', JSON.stringify(this.historial()));
  }

  private urlPaso(paso: number): string {
    const url = new URL(location.href);
    url.searchParams.set('paso', String(paso));
    return url.pathname + url.search + url.hash;
  }
}
