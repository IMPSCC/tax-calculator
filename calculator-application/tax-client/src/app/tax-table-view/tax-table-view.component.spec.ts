import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaxTableViewComponent } from './tax-table-view.component';

describe('TaxTableViewComponent', () => {
  let component: TaxTableViewComponent;
  let fixture: ComponentFixture<TaxTableViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaxTableViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TaxTableViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
