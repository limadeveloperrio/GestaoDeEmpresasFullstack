import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EdicaoEmpresas } from './edicao-empresas';

describe('EdicaoEmpresas', () => {
  let component: EdicaoEmpresas;
  let fixture: ComponentFixture<EdicaoEmpresas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EdicaoEmpresas]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EdicaoEmpresas);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
