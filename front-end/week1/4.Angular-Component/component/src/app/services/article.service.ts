import { Injectable } from '@angular/core';
import { Article } from '../model/article';
import { ARTICLES } from '../mock-articles';

@Injectable({
  providedIn: 'root',
})
export class ArticleService {
  articles: Article[] = ARTICLES;
  getArticles(): Article[] {
    return this.articles;
  }

  addArticle(article: Article): void {
    article.url = 'https://' + article.url;
    this.articles.push(article);
  }
  constructor() {}
}
