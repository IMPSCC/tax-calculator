import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class TaxInput{
  constructor(
    public year:string,
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

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient:HttpClient){

  }

  public relayTaxParameters(taxInput : TaxInput)
  {
    console.log("Sumitting tax paremeters for calculation in the HttpClient......!!!");
    return this.httpClient.post<Results>("http://localhost:8080/employees", taxInput);
  }

}
