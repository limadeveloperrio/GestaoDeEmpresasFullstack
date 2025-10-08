import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaFuncionarios } from './consulta-funcionarios';

describe('ConsultaFuncionarios', () => {
  let component: ConsultaFuncionarios;
  let fixture: ComponentFixture<ConsultaFuncionarios>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultaFuncionarios]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultaFuncionarios);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
