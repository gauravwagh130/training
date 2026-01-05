import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Showuser } from './showuser';

describe('Showuser', () => {
  let component: Showuser;
  let fixture: ComponentFixture<Showuser>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Showuser]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Showuser);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
