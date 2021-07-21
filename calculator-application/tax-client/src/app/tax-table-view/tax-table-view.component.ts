import { Component, OnInit } from '@angular/core';
import { HttpClientService,TaxTableResults} from '../service/http-client.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-tax-table-view',
  templateUrl: './tax-table-view.component.html',
  styleUrls: ['./tax-table-view.component.scss']
})

export class TaxTableViewComponent implements OnInit {

  taxTablesMap : Map<string,Array<TaxTableResults>> = new Map<string, Array<TaxTableResults>>([["", [new TaxTableResults("","","")]]]);
  taxTableByYearArray1 : TaxTableResults [] = [];
  taxTableByYearArray2 : TaxTableResults [] = [];

  constructor(private httpReference: HttpClientService,private router: Router,private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {

    this.httpReference.getTaxTableByYear("2021").subscribe(
     (response : Array<TaxTableResults>) =>{
       
       this.taxTableByYearArray1= response;

      }
    );
    this.httpReference.getTaxTableByYear("2020").subscribe(
     (response : Array<TaxTableResults>) =>{
       
       this.taxTableByYearArray2= response;

      }
    );
   
  }
}
