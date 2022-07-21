import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateConsumerBusinessComponent } from './create-consumer-business.component';

describe('CreateConsumerBusinessComponent', () => {
  let component: CreateConsumerBusinessComponent;
  let fixture: ComponentFixture<CreateConsumerBusinessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateConsumerBusinessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateConsumerBusinessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
