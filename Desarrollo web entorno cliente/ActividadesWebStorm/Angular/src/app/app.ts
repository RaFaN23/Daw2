import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Compontente2} from './compontente2/compontente2';
import {Semaforo} from './semaforo/semaforo';

@Component({
  imports: [Compontente2,Semaforo],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('Angular');
}
