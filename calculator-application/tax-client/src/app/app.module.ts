import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { OutputComponent } from './output/output.component';
import { CalculatorService } from './service/calculator.service';
import { FormsModule } from '@angular/forms';
import { TaxResultsComponent } from './tax-results/tax-results.component';

@NgModule({
  declarations: [
    AppComponent,
    OutputComponent,
    TaxResultsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CalculatorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
