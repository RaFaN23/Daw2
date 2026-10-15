import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Compontente2 } from './compontente2';

describe('Compontente2', () => {
  let component: Compontente2;
  let fixture: ComponentFixture<Compontente2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Compontente2],
    }).compileComponents();

    fixture = TestBed.createComponent(Compontente2);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
