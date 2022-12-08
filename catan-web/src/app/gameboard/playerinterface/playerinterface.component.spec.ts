import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerinterfaceComponent } from './playerinterface.component';

describe('PlayerinterfaceComponent', () => {
  let component: PlayerinterfaceComponent;
  let fixture: ComponentFixture<PlayerinterfaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerinterfaceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlayerinterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
