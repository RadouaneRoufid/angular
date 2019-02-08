import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FileUploadModule} from 'ng2-file-upload';

import { AppComponent } from './app.component';
import { ImgCompressorDirective } from './img-compressor.directive';

@NgModule({
  declarations: [
    AppComponent,
    ImgCompressorDirective
  ],
  imports: [
    BrowserModule,
    FileUploadModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
