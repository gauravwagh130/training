import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonEx } from './button-ex';

describe('ButtonEx', () => {
  let component: ButtonEx;
  let fixture: ComponentFixture<ButtonEx>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ButtonEx]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ButtonEx);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
