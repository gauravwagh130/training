import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployShow } from './employ-show';

describe('EmployShow', () => {
  let component: EmployShow;
  let fixture: ComponentFixture<EmployShow>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployShow]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployShow);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
