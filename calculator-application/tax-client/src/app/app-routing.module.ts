import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {OutputComponent} from './output/output.component';
import {TaxTableViewComponent} from './tax-table-view/tax-table-view.component';

const routes: Routes = [
  { path: 'output', component: OutputComponent },
  { path: 'app-tax-table-view', component: TaxTableViewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
