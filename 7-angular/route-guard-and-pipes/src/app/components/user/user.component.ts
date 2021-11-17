import { TheoryService } from './../../services/theory.service';
import { UserService } from 'src/app/services/user.service';
import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  @HostListener('click')
  clicked(){
    console.log('Clicked!!!!')
  }

  title = "In the UserComponent"
  age = 4;

  //  we're using the service to inkect data into our component
  // my goal: is to render each user object within the the userService that I've declared as user
  constructor(public userService: UserService, public theoryService: TheoryService) { }

  // this will be triggered by the HostListener binding as well
  getTheory(userId: number): any {

    console.log('file: user.component.ts ~ UserComponent ~ getTheory() ~ UserId is' + userId);
    return this.theoryService.getTheory(userId);

  }
  

}
