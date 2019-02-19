import {Directive, HostBinding, Input} from '@angular/core';
import {DomSanitizer, SafeHtml} from '@angular/platform-browser';

@Directive({
  selector: '[sanitizeHtml]'
})
export class SanitizeHtmlDirective {

  @Input() sanitizeHtml: string;

  constructor(private sanitizer: DomSanitizer) {
  }

  @HostBinding('innerHtml')
  get innerHtml(): SafeHtml {
    return this.sanitizer.bypassSecurityTrustHtml(this.sanitizeHtml);
  }

}
