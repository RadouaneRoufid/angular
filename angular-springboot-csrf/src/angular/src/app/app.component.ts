import {Component, OnInit} from '@angular/core';
import {ArticleService} from './services/article.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'angular';

  constructor(private articleService: ArticleService) {

  }

  ngOnInit(): void {
    this.articleService.getArticle().subscribe(title => this.title = title);
  }
}
