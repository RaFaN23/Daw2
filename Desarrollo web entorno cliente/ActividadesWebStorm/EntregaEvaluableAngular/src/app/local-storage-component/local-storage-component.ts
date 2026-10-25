import { Component, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { aplicarTema } from '../tema';

@Component({
  selector: 'app-local-storage',
  imports: [FormsModule],
  templateUrl: './local-storage-component.html',
  styleUrl: './local-storage-component.css',
})
export class LocalStorageComponent implements OnInit {

  nombre = signal('');
  visitas = signal(0);
  ultimaVisita = signal('');
  tema = signal('');

  nombreEscrito: string = '';
  mensaje = signal('');

  ngOnInit(): void {
    this.nombre.set(localStorage.getItem('nombre') ?? '');
    this.tema.set(localStorage.getItem('tema') ?? '');

    const visitasGuardadas = Number(localStorage.getItem('visitas') ?? 0);
    this.visitas.set(visitasGuardadas + 1);
    this.ultimaVisita.set(localStorage.getItem('ultimaVisita') ?? '');

    localStorage.setItem('visitas', String(this.visitas()));
    localStorage.setItem('ultimaVisita', new Date().toLocaleString());

    aplicarTema();
  }

  guardarNombre(): void {
    this.mensaje.set('');

    if (this.nombreEscrito.trim() === '') {
      this.mensaje.set('Escribe tu nombre.');
      return;
    }

    this.nombre.set(this.nombreEscrito.trim());
    localStorage.setItem('nombre', this.nombre());
    this.nombreEscrito = '';
  }

  elegirTema(tema: string): void {
    this.tema.set(tema);
    localStorage.setItem('tema', tema);
    aplicarTema();
  }

  borrar(): void {
    for (const clave of ['nombre', 'visitas', 'ultimaVisita', 'tema']) {
      localStorage.removeItem(clave);
    }

    this.nombre.set('');
    this.visitas.set(0);
    this.ultimaVisita.set('');
    this.tema.set('');
    this.mensaje.set('Datos de localStorage eliminados.');

    aplicarTema();
  }
}
