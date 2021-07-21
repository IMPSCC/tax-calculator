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
  results: Results = new Results("","","","","");

  constructor(private calculatorService: CalculatorService,private httpReference: HttpClientService,private router: Router,private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
     console.log('Sumitting tax paremeters for calculation witout2 !!!');
    this.calculatorService.getAll().subscribe(
      data => {
        this.tax = data;
      },
    );
  }

  submitTaxParameters(): void{

    console.log('Sumitting tax paremeters for calculation witout !!!');
    
    this.httpReference.relayTaxParameters(this.tax).subscribe(
      (response : Results ) => {
        console.log("Assigning the results from the response");
        this.results = response;
         console.log("@@@@@@The response of tax calculation is not annulTax : "+this.results.annulTax);
      console.log("@@@@@@The response of tax calculation is not null monthlSalaryAfterTax : "+this.results.monthlSalaryAfterTax);
      console.log("@@@@@@The response of tax calculation is not null monthlySalaryAfterTaxCredits : "+this.results.monthlySalaryAfterTaxCredits);
      console.log("@@@@@@The response of tax calculation is not null monthlyTaxCredit : "+this.results.monthlyTaxCredit);
      console.log("@@@@@@The response of tax calculation is not null monthlyTax : "+this.results.monthlyTax);
        this.router.navigate(['/tax-results']);
        
      }
    );
  
  }

}
