import {Component, OnInit} from '@angular/core';
import {FileUploader} from 'ng2-file-upload';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  uploader: FileUploader;

  ngOnInit(): void {
    this.uploader = new FileUploader({url: 'api/files', autoUpload: true});
  }
}
