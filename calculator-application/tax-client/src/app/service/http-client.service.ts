import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class TaxInput{
  constructor(
    public taxYear:string,
    public age:string,
    public totalTaxableIncome:string,
    public medicalAidMembers:string,
  ) {}
}
  
export class Results{
  constructor(
    public monthlyTax:string,
    public annulTax:string,
    public monthlyTaxCredit:string,
    public monthlSalaryAfterTax:string,
    public monthlySalaryAfterTaxCredits:string,
  ) {}
}

export class TaxTableResults{
  constructor(
    public taxYear:string,
    public taxableIncomeRange:string,
    public rateOfTaxDescription:string,
  ) {}
}


@Injectable({
  providedIn: 'root'
})

export class HttpClientService {

  

constructor(private httpClient:HttpClient){}

  public getTaxTableByYear(taxYear :string)
  {
    return this.httpClient.post<TaxTableResults[]>("http://localhost:8080/taxtable", taxYear);
  }

  public relayTaxParameters(taxInput : TaxInput)
  {
    console.log("Sumitting tax paremeters for calculation in the HttpClient......!!! "+taxInput.taxYear);
    
    return this.httpClient.post<Results>("http://localhost:8080/taxcalculation", taxInput);
  }
  
  public getTaxTables()
  {
   console.log("tax table view HTTP execution ...!!!"); 
	 return this.httpClient.get<Map<string,TaxTableResults[]>>("http://localhost:8080/taxtables");
  }
  
  public getTaxResults(taxInput : TaxInput)
  {
    console.log("Sumitting tax paremeters for calculation in the HttpClient......!!!");
    return this.httpClient.get<Results>("http://localhost:8080/taxcalculation");
  }

}
