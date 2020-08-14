import { Injectable } from '@angular/core';
import { Word } from '../word';
@Injectable({
  providedIn: 'root',
})
export class DictionaryService {
  dictionary: Word[] = [
    {
      key: 'hello',
      meaning: 'xin chao',
    },
    {
      key: 'goodbye',
      meaning: 'tam biet',
    },
    {
      key: 'apple',
      meaning: 'tao',
    },
    {
      key: 'banana',
      meaning: 'chuoi',
    },
    {
      key: 'car',
      meaning: 'oto',
    },
    {
      key: 'phone',
      meaning: 'dien thoai',
    },
  ];

  find(wordToFind: string): string {
    if (!wordToFind) {
      return '';
    }
    const foundWord = this.dictionary.find(
      (element) => element.key === wordToFind
    );
    return foundWord ? foundWord.meaning : 'Not found';
  }

  constructor() {}

  getAll(): Word[] {
    return this.dictionary;
  }
}
