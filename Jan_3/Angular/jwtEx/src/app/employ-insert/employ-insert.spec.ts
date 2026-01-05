import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployInsert } from './employ-insert';

describe('EmployInsert', () => {
  let component: EmployInsert;
  let fixture: ComponentFixture<EmployInsert>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployInsert]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployInsert);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
