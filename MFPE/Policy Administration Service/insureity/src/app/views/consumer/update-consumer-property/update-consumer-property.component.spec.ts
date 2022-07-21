import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateConsumerPropertyComponent } from './update-consumer-property.component';

describe('UpdateConsumerPropertyComponent', () => {
  let component: UpdateConsumerPropertyComponent;
  let fixture: ComponentFixture<UpdateConsumerPropertyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateConsumerPropertyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateConsumerPropertyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
