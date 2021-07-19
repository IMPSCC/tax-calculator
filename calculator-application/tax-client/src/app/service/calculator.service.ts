import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs';
import {map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor(private http: HttpClient) { }
    
    getAll(): Observable<any>{
      return this.http.get('http://localhost:8080/wena')
          .pipe(map(res => res));
    }
  
}
