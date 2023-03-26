import { Component, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { TodoComponent } from './admin/todo/todo.component';
import { UserComponent } from './Users/users/user.component';



const routes: Routes =[

  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'

  },
  {
    path:'todo',
    component:TodoComponent,
    pathMatch:'full'
  },
  {
    path:'user',
    component:UserComponent,
    pathMatch:'full'
  }
];

@NgModule({
 
  imports: [RouterModule.forRoot(routes)],
  exports:[RouterModule],
})
export class AppRoutingModule { }
