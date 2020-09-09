import { Component, OnInit } from '@angular/core';
import { Article } from '../model/article';
import { ArticleService } from '../services/article.service';

@Component({
  selector: 'app-new-article',
  templateUrl: './new-article.component.html',
  styleUrls: ['./new-article.component.css'],
})
export class NewArticleComponent implements OnInit {
  newArticle: Article = {
    title: '',
    url: '',
  };

  constructor(private articleService: ArticleService) {}

  save(): void {
    this.articleService.addArticle(this.newArticle);
  }

  ngOnInit(): void {}
}
