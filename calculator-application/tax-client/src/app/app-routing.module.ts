import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TaxResultsComponent} from './tax-results/tax-results.component';
import {OutputComponent} from './output/output.component';

const routes: Routes = [
  { path: 'output', component: OutputComponent },
  { path: 'tax-results', component: TaxResultsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
