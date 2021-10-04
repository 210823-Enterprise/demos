import { RegisterComponent } from './components/register/register.component';
import { MainComponent } from './components/main/main.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  { path: '', component: MainComponent },
  { path: 'main', component: MainComponent },   // the path specifies http:/localhost:4200/main
  { path: 'register', component: RegisterComponent},
  { path: '**', component: MainComponent} // this is a Wild Card Route to handle

];

// A module is a container for diff parts of your app like controllers, services, directives
// The routes, and other properties will be auto configured by npm 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
