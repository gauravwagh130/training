import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployTdf } from './employ-tdf';

describe('EmployTdf', () => {
  let component: EmployTdf;
  let fixture: ComponentFixture<EmployTdf>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployTdf]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployTdf);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
