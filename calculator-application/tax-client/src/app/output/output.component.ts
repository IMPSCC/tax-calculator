import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import {CalculatorService} from '../service/calculator.service';
import { HttpClientService, TaxInput, Results } from '../service/http-client.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.scss']
})


export class OutputComponent implements OnInit {

  tax: TaxInput = new TaxInput("","","","");
  results: Results = new Results("10","10","30","20","40");

  constructor(private calculatorService: CalculatorService,private httpReference: HttpClientService,private router: Router,private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
     console.log("Sumitting tax paremeters for calculation witout !!!");
    this.calculatorService.getAll().subscribe(
      data => {
        this.tax = data;
      },
    );
  }

  submitTaxParameters(): void{

    console.log("Sumitting tax paremeters for calculation witout !!!");
    
    this.httpReference.relayTaxParameters(this.tax).subscribe(response =>{this.results = response});
    this.router.navigate(['/tax-results']);
    
  };

}
