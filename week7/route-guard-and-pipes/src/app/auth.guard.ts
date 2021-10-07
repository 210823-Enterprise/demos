import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  // we need to inject the AuthService into the guard so we have the capability of checking whether the user is logged in
  constructor(private auth: AuthService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
   
    // call the isLogged in method from the Authenticantion Service and check if the user is logged in
    if (this.auth.isLoggedIn()) {
      return true; // if the auth guard returns true (because the user is logged in - we allows access to a route)
    } else {
      window.alert(`You don't have permission to view this page!`)
      return false; // if the guard returns false, then the user can't access it
    }

    // Now we have to attach our Auth Guard to our routing-module

  }
  
}
