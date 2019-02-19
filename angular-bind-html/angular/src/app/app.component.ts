import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ANTOHER_TEMPLATE, HTML_TEMPLATE} from './template';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  htmlTemplate = HTML_TEMPLATE;

  @ViewChild('htmlContainer') htmlContainer: ElementRef;

  ngOnInit(): void {
    this.htmlContainer.nativeElement.innerHTML = ANTOHER_TEMPLATE;
  }

}
