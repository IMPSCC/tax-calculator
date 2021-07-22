import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { OutputComponent } from './output/output.component';
import { FormsModule } from '@angular/forms';
import { TaxTableViewComponent } from './tax-table-view/tax-table-view.component';

@NgModule({
  declarations: [
    AppComponent,
    OutputComponent,
    TaxTableViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
