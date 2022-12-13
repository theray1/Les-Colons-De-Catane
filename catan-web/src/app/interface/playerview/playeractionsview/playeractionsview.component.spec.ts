import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayeractionsviewComponent } from './playeractionsview.component';

describe('PlayeractionsviewComponent', () => {
  let component: PlayeractionsviewComponent;
  let fixture: ComponentFixture<PlayeractionsviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayeractionsviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlayeractionsviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
