import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Employ } from './employ';

describe('Employ', () => {
  let component: Employ;
  let fixture: ComponentFixture<Employ>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Employ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Employ);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
