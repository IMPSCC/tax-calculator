import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaxResultsComponent } from './tax-results.component';

describe('TaxResultsComponent', () => {
  let component: TaxResultsComponent;
  let fixture: ComponentFixture<TaxResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaxResultsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TaxResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
