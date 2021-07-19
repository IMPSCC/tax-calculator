import { Component, OnInit } from '@angular/core';
import {CalculatorService} from '../service/calculator.service'
@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.scss']
})
export class OutputComponent implements OnInit {

  tax: Array<any> = [];
  
  constructor(private calculatorService: CalculatorService) { }

  ngOnInit(): void {
    this.calculatorService.getAll().subscribe(
      data => {
        this.tax = data;
      },
    );
  }

}
