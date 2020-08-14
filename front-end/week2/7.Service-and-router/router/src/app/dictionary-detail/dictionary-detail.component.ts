import { Component, OnInit, OnDestroy } from '@angular/core';
import { Word } from '../word';
import { Subscription } from 'rxjs';
import { DictionaryService } from '../service/dictionary.service';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css'],
})
export class DictionaryDetailComponent implements OnInit, OnDestroy {
  word: Word;
  sub: Subscription;
  constructor(
    public dictionaryService: DictionaryService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const key = paramMap.get('key');
      const meaning = this.dictionaryService.find(key);
      this.word = {
        key: key,
        meaning: meaning,
      };
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
