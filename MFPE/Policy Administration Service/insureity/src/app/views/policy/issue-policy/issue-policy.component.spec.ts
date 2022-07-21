import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IssuePolicyComponent } from './issue-policy.component';

describe('IssuePolicyComponent', () => {
  let component: IssuePolicyComponent;
  let fixture: ComponentFixture<IssuePolicyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IssuePolicyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IssuePolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
