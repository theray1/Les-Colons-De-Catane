import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerresourcesviewComponent } from './playerresourcesview.component';

describe('PlayerresourcesviewComponent', () => {
  let component: PlayerresourcesviewComponent;
  let fixture: ComponentFixture<PlayerresourcesviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerresourcesviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlayerresourcesviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
