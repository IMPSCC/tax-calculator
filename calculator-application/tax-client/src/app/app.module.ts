import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClient} from '@angular/common/http';
import { OutputComponent } from './output/output.component';
import { CalculatorService } from './service/calculator.service';


@NgModule({
  declarations: [
    AppComponent,
    OutputComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClient
  ],
  providers: [CalculatorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
