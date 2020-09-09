import {
  Component,
  OnInit,
  Input,
  Output,
  EventEmitter,
  SimpleChanges,
} from '@angular/core';
interface IRatingStar {
  value: number;
  active: boolean;
}

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css'],
})
export class RatingBarComponent implements OnInit {
  @Input()
  max: number;
  @Input()
  ratingValue = 5;
  @Input()
  showRatingValue = true;

  @Output()
  rateChange = new EventEmitter<number>();

  ratingStars: Array<IRatingStar> = [];

  constructor() {}

  ngOnInit(): void {
    this.calculate(this.max, this.ratingValue);
  }

  ngOnChanges(changes: SimpleChanges) {
    if ('max' in changes) {
      let max = changes.max.currentValue;
      max = typeof max === 'undefined' ? 5 : max;
      this.max = max;
      this.calculate(max, this.ratingValue);
    }
  }
  //set rating stars?
  calculate(max, ratingValue) {
    this.ratingStars = Array.from({ length: max }, (_, index) => ({
      value: index + 1,
      active: index < ratingValue,
    }));
  }
  //on click
  select(index) {
    this.ratingValue = index + 1;
    this.ratingStars.forEach(
      (item, idx) => (item.active = idx < this.ratingValue)
    );
    this.rateChange.emit(this.ratingValue);
  }
  hover(hoverIndex) {
    this.ratingStars.forEach((item, idx) => (item.active = idx <= hoverIndex));
  }
  reset() {
    this.ratingStars.forEach(
      (item, idx) => (item.active = idx < this.ratingValue)
    );
  }
}
