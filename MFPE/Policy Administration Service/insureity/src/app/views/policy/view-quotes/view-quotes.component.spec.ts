import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewQuotesComponent } from './view-quotes.component';

describe('ViewQuotesComponent', () => {
  let component: ViewQuotesComponent;
  let fixture: ComponentFixture<ViewQuotesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewQuotesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewQuotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
