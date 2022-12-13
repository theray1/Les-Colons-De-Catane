import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventlistviewComponent } from './eventlistview.component';

describe('EventlistviewComponent', () => {
  let component: EventlistviewComponent;
  let fixture: ComponentFixture<EventlistviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventlistviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EventlistviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
