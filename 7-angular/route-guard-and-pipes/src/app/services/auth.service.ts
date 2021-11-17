import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  isLoggedIn(): boolean {

    // complex logic for checking a User's credentials before they can access a page
    return true;
  }

  // check out Angular JsonWebToken (JWT) with Spring Boot

}
