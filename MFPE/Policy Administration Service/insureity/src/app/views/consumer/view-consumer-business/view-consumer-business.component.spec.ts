import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewConsumerBusinessComponent } from './view-consumer-business.component';

describe('ViewConsumerBusinessComponent', () => {
  let component: ViewConsumerBusinessComponent;
  let fixture: ComponentFixture<ViewConsumerBusinessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewConsumerBusinessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewConsumerBusinessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
