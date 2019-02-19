import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SafeHtmlPipe } from './safe-html.pipe';
import { SanitizeHtmlDirective } from './sanitize-html.directive';

@NgModule({
  declarations: [
    AppComponent,
    SafeHtmlPipe,
    SanitizeHtmlDirective
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
