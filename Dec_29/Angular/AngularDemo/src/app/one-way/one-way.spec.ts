import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OneWay } from './one-way';

describe('OneWay', () => {
  let component: OneWay;
  let fixture: ComponentFixture<OneWay>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OneWay]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OneWay);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
