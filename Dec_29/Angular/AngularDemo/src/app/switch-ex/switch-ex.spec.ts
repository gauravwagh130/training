import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SwitchEx } from './switch-ex';

describe('SwitchEx', () => {
  let component: SwitchEx;
  let fixture: ComponentFixture<SwitchEx>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SwitchEx]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SwitchEx);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
