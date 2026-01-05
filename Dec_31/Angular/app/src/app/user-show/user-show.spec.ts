import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserShow } from './user-show';

describe('UserShow', () => {
  let component: UserShow;
  let fixture: ComponentFixture<UserShow>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserShow]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserShow);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
