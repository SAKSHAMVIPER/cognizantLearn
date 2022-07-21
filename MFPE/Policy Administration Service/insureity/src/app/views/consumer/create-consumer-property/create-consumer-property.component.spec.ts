import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateConsumerPropertyComponent } from './create-consumer-property.component';

describe('CreateConsumerPropertyComponent', () => {
  let component: CreateConsumerPropertyComponent;
  let fixture: ComponentFixture<CreateConsumerPropertyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateConsumerPropertyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateConsumerPropertyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
