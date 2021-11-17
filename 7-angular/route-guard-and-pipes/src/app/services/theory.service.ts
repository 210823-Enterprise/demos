import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TheoryService {

  constructor() { }


  readonly theories = [

    {
      title: 'Quantum Theory',
      userId: 1
    },
    {
      title: 'Theory of Relativity',
      userId: 2
    }
  ]

  getTheory(userId: number) {
    return this.theories.find(t => t.userId === userId)
  }

}
