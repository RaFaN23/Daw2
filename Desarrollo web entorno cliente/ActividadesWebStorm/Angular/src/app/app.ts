import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Compontente2} from './compontente2/compontente2';

@Component({
  imports: [RouterOutlet, Compontente2],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('Angular');
}
