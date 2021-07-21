import { Component, OnInit } from '@angular/core';
import { HttpClientService, TaxInput, Results } from '../service/http-client.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-tax-results',
  templateUrl: './tax-results.component.html',
  styleUrls: ['./tax-results.component.scss']
})
export class TaxResultsComponent implements OnInit {

  constructor(private httpReference: HttpClientService,private router: Router,private activatedRouter: ActivatedRoute) { }

  taxResults: Results = new Results("","","","","");

  ngOnInit(): void {

    console.log("redirected to the Results component...!!!");
  }

}
