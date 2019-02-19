import {Component} from '@angular/core';
import {HTML_TEMPLATE} from './template';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  htmlTemplate = HTML_TEMPLATE;
}
