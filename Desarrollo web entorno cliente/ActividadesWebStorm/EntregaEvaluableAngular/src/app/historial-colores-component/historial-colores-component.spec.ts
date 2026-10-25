import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HistorialColoresComponent } from './historial-colores-component';

describe('HistorialColoresComponent', () => {
  let component: HistorialColoresComponent;
  let fixture: ComponentFixture<HistorialColoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HistorialColoresComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(HistorialColoresComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
