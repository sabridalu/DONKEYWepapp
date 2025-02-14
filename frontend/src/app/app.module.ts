import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

const routes: Routes = [
  {
    path: '',
    component: AppComponent
  }
];
@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppComponent,
    HttpClientModule,
    RouterModule.forRoot(routes, { scrollPositionRestoration: 'enabled', anchorScrolling: 'enabled' })
  ],
  providers: [],
  bootstrap: []
})
export class AppModule {}
