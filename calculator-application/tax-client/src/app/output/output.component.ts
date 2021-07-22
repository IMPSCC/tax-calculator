import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
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
  flag : boolean = false;

  constructor(private httpReference: HttpClientService,private router: Router,private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    
  }

  submitTaxParameters(): void{

    this.httpReference.relayTaxParameters(this.tax).subscribe(
      (response : Results ) => {
        console.log("Assigning the results from the response");
        this.results = response;
        this.flag = true;
      }
    );
  
  }

  back() : void{
    this.flag = false;
    this.tax = new TaxInput("","","","");
    this.router.navigate(["/output"]);
  }
}
