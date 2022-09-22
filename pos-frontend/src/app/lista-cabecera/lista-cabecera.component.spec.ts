import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCabeceraComponent } from './lista-cabecera.component';

describe('ListaCabeceraComponent', () => {
  let component: ListaCabeceraComponent;
  let fixture: ComponentFixture<ListaCabeceraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaCabeceraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaCabeceraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
