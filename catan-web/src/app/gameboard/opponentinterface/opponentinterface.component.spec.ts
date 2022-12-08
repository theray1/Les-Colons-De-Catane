import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpponentinterfaceComponent } from './opponentinterface.component';

describe('OpponentinterfaceComponent', () => {
  let component: OpponentinterfaceComponent;
  let fixture: ComponentFixture<OpponentinterfaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpponentinterfaceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OpponentinterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
