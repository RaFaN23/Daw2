import { Component, signal } from '@angular/core';

import {FechaHoraComponent} from './fecha-hora-component/fecha-hora-component';
import { NumeroAleatorioComponent } from './numero-aleatorio-component/numero-aleatorio-component';
import { HistorialColoresComponent } from './historial-colores-component/historial-colores-component';
import { VentanaHijaComponent } from './ventana-hija-component/ventana-hija-component';
import { CookiesComponent } from './cookies-component/cookies-component';
import { LocalStorageComponent } from './local-storage-component/local-storage-component';

@Component({
  imports: [FechaHoraComponent, NumeroAleatorioComponent, HistorialColoresComponent, VentanaHijaComponent, CookiesComponent, LocalStorageComponent],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('EntregaEvaluableAngular');
}
