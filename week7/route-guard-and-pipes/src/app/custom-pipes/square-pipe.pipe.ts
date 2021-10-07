import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squarePipe'
})
export class SquarePipePipe implements PipeTransform {

  transform(value: number): number {
    return value * value;
  }

}
