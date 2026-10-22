import { Component, OnDestroy, OnInit, signal } from '@angular/core';

@Component({
  selector: 'app-fecha-hora',
  templateUrl: './fecha-hora-component.html',
  styleUrl: './fecha-hora-component.css'
})
export class FechaHoraComponent implements OnInit, OnDestroy {

  // Se usan signals para que la vista se actualice cada segundo
  fechaActual = signal(new Date());
  formato24 = signal(true);
  mostrarSegundoReloj = signal(false);
  ciudadSeleccionada = signal('Europe/London');

  ciudades = [
    { nombre: 'Londres', zona: 'Europe/London' },
    { nombre: 'París', zona: 'Europe/Paris' },
    { nombre: 'Nueva York', zona: 'America/New_York' },
    { nombre: 'Los Ángeles', zona: 'America/Los_Angeles' },
    { nombre: 'Tokio', zona: 'Asia/Tokyo' },
    { nombre: 'Sídney', zona: 'Australia/Sydney' }
  ];

  private intervalo: ReturnType<typeof setInterval> | undefined;

  ngOnInit(): void {
    this.intervalo = setInterval(() => {
      this. fechaActual.set(new Date());
    }, 1000);
  }

  ngOnDestroy(): void {
    clearInterval(this.intervalo);
  }

  cambiarFormato(evento: Event): void {
    const casilla = evento.target as HTMLInputElement;
    this.formato24.set(casilla.checked);
  }

  cambiarSegundoReloj(evento: Event): void {
    const casilla = evento.target as HTMLInputElement;
    this.mostrarSegundoReloj.set(casilla.checked);
  }

  cambiarCiudad(evento: Event): void {
    const seleccion = evento.target as HTMLSelectElement;
    this.ciudadSeleccionada.set(seleccion.value);
  }

  // Devuelve la fecha con formato dd-mm-yyyy hh:mm:ss (y AM/PM si es formato 12h).
  // Si se pasa una zona horaria, la hora se calcula para esa zona.
  formatearFecha(fecha: Date, zona?: string): string {
    const opciones: Intl.DateTimeFormatOptions = {
      day: '2-digit',
      month: '2-digit',
      year: 'numeric',
      hour: '2-digit',
      minute: '2-digit',
      second: '2-digit',
      hourCycle: this.formato24() ? 'h23' : 'h12',
      timeZone: zona
    };

    const partes = new Intl.DateTimeFormat('en-GB', opciones).formatToParts(fecha);

    let dia = '';
    let mes = '';
    let anio = '';
    let hora = '';
    let minutos = '';
    let segundos = '';
    let periodo = '';

    for (const parte of partes) {
      switch (parte.type) {
        case 'day': dia = parte.value; break;
        case 'month': mes = parte.value; break;
        case 'year': anio = parte.value; break;
        case 'hour': hora = parte.value; break;
        case 'minute': minutos = parte.value; break;
        case 'second': segundos = parte.value; break;
        case 'dayPeriod': periodo = parte.value.toUpperCase(); break;
      }
    }

    let resultado = `${dia}-${mes}-${anio} ${hora}:${minutos}:${segundos}`;

    if (!this.formato24()) {
      resultado += ' ' + periodo;
    }

    return resultado;
  }

  nombreCiudad(): string {
    const ciudad = this.ciudades.find(c => c.zona === this.ciudadSeleccionada());
    return ciudad ? ciudad.nombre : '';
  }
}
