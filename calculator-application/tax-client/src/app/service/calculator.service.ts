import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs';
import {map } from 'rxjs/operators';

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
export class CalculatorService {

  constructor(private http: HttpClient) { }
    
    getAll(): Observable<any>{
      return this.http.get('http://localhost:8080/wena')
          .pipe(map(res => res));
    }

    public getTaxTables()
  {
   console.log("Tax tables retrieval ntest call"); 
	 return this.http.get<Map<String,TaxTableResults[]>>('http://localhost:8080/taxtables');
  }
  
}
