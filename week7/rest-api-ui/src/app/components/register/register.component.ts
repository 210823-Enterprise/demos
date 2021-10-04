import { User, Address } from './../../models/user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  title = 'Register User';

  // public, private, protected
  public user = new User('', '', '', '', '', [])
  public address = new Address('', '', '', '')

  constructor() { } // HttpClientModule

  // void is the return type (like Java)
  public testUserObj(): void {

    // after we've bound the input proerties to the User and Addres properties of the component, 
    // we print it to the console
    
    // push the address to the User's address array:
    this.user.addresses.push(this.address);
    console.log(this.user);

  }

}
