import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import {CalculatorService} from '../service/calculator.service';
import { HttpClientService, TaxInput } from '../service/http-client.service';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.scss']
})


export class OutputComponent implements OnInit {

  tax: TaxInput = new TaxInput("","","","");
  
  constructor(private calculatorService: CalculatorService,private httpReference: HttpClientService) { }

  ngOnInit(): void {
    this.calculatorService.getAll().subscribe(
      data => {
        this.tax = data;
      },
    );
  }

  submitTaxParameters(): void{

    console.log("Sumitting tax paremeters for calculation!!!");
    this.httpReference.relayTaxParameters(this.tax);
  };

}
