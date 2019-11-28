import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonatebloodComponent } from './donateblood.component';

describe('DonatebloodComponent', () => {
  let component: DonatebloodComponent;
  let fixture: ComponentFixture<DonatebloodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonatebloodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonatebloodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
