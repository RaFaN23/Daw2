import { Component, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { aplicarTema, leerCookie } from '../tema';

@Component({
  selector: 'app-cookies',
  imports: [FormsModule],
  templateUrl: './cookies-component.html',
  styleUrl: './cookies-component.css',
})
export class CookiesComponent implements OnInit {

  readonly duracion = 60 * 60 * 24;

  nombre = signal('');
  visitas = signal(0);
  ultimaVisita = signal('');
  tema = signal('');

  nombreEscrito: string = '';
  mensaje = signal('');

  ngOnInit(): void {
    this.nombre.set(leerCookie('nombre') ?? '');
    this.tema.set(leerCookie('tema') ?? '');

    const visitasGuardadas = Number(leerCookie('visitas') ?? 0);
    this.visitas.set(visitasGuardadas + 1);
    this.ultimaVisita.set(leerCookie('ultimaVisita') ?? '');

    this.guardarCookie('visitas', String(this.visitas()));
    this.guardarCookie('ultimaVisita', new Date().toLocaleString());

    aplicarTema();
  }

  guardarNombre(): void {
    this.mensaje.set('');

    if (this.nombreEscrito.trim() === '') {
      this.mensaje.set('Escribe tu nombre.');
      return;
    }

    this.nombre.set(this.nombreEscrito.trim());
    this.guardarCookie('nombre', this.nombre());
    this.nombreEscrito = '';
  }

  elegirTema(tema: string): void {
    this.tema.set(tema);
    this.guardarCookie('tema', tema);
    aplicarTema();
  }

  borrar(): void {
    for (const clave of ['nombre', 'visitas', 'ultimaVisita', 'tema']) {
      document.cookie = `${clave}=; max-age=0; path=/`;
    }

    this.nombre.set('');
    this.visitas.set(0);
    this.ultimaVisita.set('');
    this.tema.set('');
    this.mensaje.set('Cookies eliminadas.');

    aplicarTema();
  }

  private guardarCookie(clave: string, valor: string): void {
    document.cookie = `${clave}=${encodeURIComponent(valor)}; max-age=${this.duracion}; path=/`;
  }
}
