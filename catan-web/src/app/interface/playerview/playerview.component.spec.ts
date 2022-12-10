import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerviewComponent } from './playerview.component';

describe('PlayerviewComponent', () => {
  let component: PlayerviewComponent;
  let fixture: ComponentFixture<PlayerviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlayerviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
