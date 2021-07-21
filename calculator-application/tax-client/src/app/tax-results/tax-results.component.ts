import { Component, OnInit } from '@angular/core';
import { Results } from '../service/http-client.service';

@Component({
  selector: 'app-tax-results',
  templateUrl: './tax-results.component.html',
  styleUrls: ['./tax-results.component.scss']
})
export class TaxResultsComponent implements OnInit {

  constructor() { }

  taxResults: Results = new Results("12","34","55","23","56");
  ngOnInit(): void {

    console.log("redirected to the Results component...!!!")
  }

}
