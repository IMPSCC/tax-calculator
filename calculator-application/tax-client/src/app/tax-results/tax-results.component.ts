import { Component, OnInit } from '@angular/core';
import { Results } from '../service/http-client.service';

@Component({
  selector: 'app-tax-results',
  templateUrl: './tax-results.component.html',
  styleUrls: ['./tax-results.component.scss']
})
export class TaxResultsComponent implements OnInit {

  constructor() { }

  taxResults: Results = new Results("","","","","",);
  ngOnInit(): void {
  }

}
