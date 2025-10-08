import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdicaoFuncionarios } from './edicao-funcionarios';

describe('EdicaoFuncionarios', () => {
  let component: EdicaoFuncionarios;
  let fixture: ComponentFixture<EdicaoFuncionarios>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EdicaoFuncionarios]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EdicaoFuncionarios);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
