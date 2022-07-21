import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewConsumerPropertyComponent } from './view-consumer-property.component';

describe('ViewConsumerPropertyComponent', () => {
  let component: ViewConsumerPropertyComponent;
  let fixture: ComponentFixture<ViewConsumerPropertyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewConsumerPropertyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewConsumerPropertyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
