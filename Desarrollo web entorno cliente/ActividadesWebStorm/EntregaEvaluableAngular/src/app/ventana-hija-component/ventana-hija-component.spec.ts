import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VentanaHijaComponent } from './ventana-hija-component';

describe('VentanaHijaComponent', () => {
  let component: VentanaHijaComponent;
  let fixture: ComponentFixture<VentanaHijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VentanaHijaComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(VentanaHijaComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
