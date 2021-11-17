import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService { // this service's only job is to provide a component with objects

  constructor() { }

  // inject some objects somewhere else in our app
  readonly users = [

    {
      id: 1,
      name: 'Niels Bohr'
    },
    {
      id: 2,
      name: 'Albert Einstein'
    }
  ]

}
