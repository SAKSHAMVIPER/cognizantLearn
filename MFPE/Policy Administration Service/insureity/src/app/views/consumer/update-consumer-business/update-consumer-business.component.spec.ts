import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateConsumerBusinessComponent } from './update-consumer-business.component';

describe('UpdateConsumerBusinessComponent', () => {
  let component: UpdateConsumerBusinessComponent;
  let fixture: ComponentFixture<UpdateConsumerBusinessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateConsumerBusinessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateConsumerBusinessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
