import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerstateviewComponent } from './playerstateview.component';

describe('PlayerstateviewComponent', () => {
  let component: PlayerstateviewComponent;
  let fixture: ComponentFixture<PlayerstateviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayerstateviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PlayerstateviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
