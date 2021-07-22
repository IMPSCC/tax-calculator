import { Component, OnInit } from '@angular/core';
import { HttpClientService,TaxTableResults} from '../service/http-client.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-tax-table-view',
  templateUrl: './tax-table-view.component.html',
  styleUrls: ['./tax-table-view.component.scss']
})


export class TaxTableViewComponent implements OnInit {

  
  taxTableByYearArray2020 : TaxTableResults [] = [];
  taxTableByYearArray2021 : TaxTableResults [] = [];
 

  constructor(private httpReference: HttpClientService,private router: Router,private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {

    this.httpReference.getTaxTableByYear("2020").subscribe(
     (response : Array<TaxTableResults>) =>{
       
       this.taxTableByYearArray2020= response;

      }
    );
    this.httpReference.getTaxTableByYear("2021").subscribe(
     (response : Array<TaxTableResults>) =>{
       
       this.taxTableByYearArray2021= response;

      }
    );
   
  }
}
