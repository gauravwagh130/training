import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmploySearch } from './employ-search';

describe('EmploySearch', () => {
  let component: EmploySearch;
  let fixture: ComponentFixture<EmploySearch>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmploySearch]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmploySearch);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
