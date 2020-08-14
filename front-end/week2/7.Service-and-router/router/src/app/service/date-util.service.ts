import { Injectable } from '@angular/core';
import {
  addMonths,
  addYears,
  differenceInDays,
  differenceInMonths,
  differenceInWeeks,
  differenceInYears,
} from 'date-fns';

@Injectable({
  providedIn: 'root',
})
export class DateUtilService {
  constructor() {}
  getDiffToNow(target: string | number | Date): string {
    const result: string[] = [];
    const now = new Date();
    target = new Date(target);
    const years = differenceInYears(now, target);
    if (years > 0) {
      result.push(`${years} years`);
      target = addYears(target, years);
    }
    const months = differenceInMonths(now, target);
    if (months > 0) {
      result.push(`${months} months`);
      target = addMonths(target, months);
    }
    const days = differenceInDays(now, target);
    if (days > 0) {
      result.push(`${days} days`);
    }
    return result.join(' ');
  }
}
