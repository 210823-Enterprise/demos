import { Pipe, PipeTransform } from '@angular/core';
import { SelectControlValueAccessor } from '@angular/forms';
import { TheoryService } from '../services/theory.service';

@Pipe({
  name: 'theory'
})
export class TheoryPipe implements PipeTransform {

  // Pipes are used to reuse logic

  constructor(private theoryService: TheoryService) {}

  transform(userId: number, ...args: unknown[]): any {
    console.log(userId);
    return this.theoryService.getTheory(userId);
  }

  // we can apply this Custom Pipe to any template to capture data and
  // transform it

}
