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
    public taxCredit:string,
    public monthlSalaryAfterTax:string,
    public monthlySalaryAfterTaxCredits:string,
  ) {}
}

export class TaxTableResults{
  constructor(
    public taxYear:string,
    public taxableIncomePercent:string,
    public taxableIncomeMinimumAmountRange:string,
    public taxableIncomeMaximumAmountRange:string,
    public defaultTaxAmount:string,
  ) {}
}


@Injectable({
  providedIn: 'root'
})

export class HttpClientService {

constructor(private httpClient:HttpClient){}

  public relayTaxParameters(taxInput : TaxInput)
  {
    console.log("Sumitting tax paremeters for calculation in the HttpClient......!!! "+taxInput.taxYear);
    
    return this.httpClient.post<Results>("http://localhost:8080/taxcalculation", taxInput);
  }
  
  public getTaxTables()
  {
   console.log("test call"); 
	 return this.httpClient.get<Map<String,TaxTableResults[]>>('http://localhost:8080/taxtables');
  }
  
  public getTaxResults(taxInput : TaxInput)
  {
    console.log("Sumitting tax paremeters for calculation in the HttpClient......!!!");
    return this.httpClient.get<Results>("http://localhost:8080/taxcalculation");
  }

}
