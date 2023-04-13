import { Component, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { TodoComponent } from './admin/todo/todo.component';
import { UserComponent } from './admin/usertask/user.component';
import { PanelComponent } from './admin/panel/panel.component';
import { HomeComponent } from './pages/home/home.component';



const routes: Routes =[

  {
    path:'',
    component:LoginComponent,
    pathMatch:'full',
  },
  {
    path:'admin',
    component:PanelComponent,
    children:[
      {
        path: 'todo',
        component: TodoComponent
      },
      {
        path:'usertask',
        component: UserComponent
      },
    ]
  },
];

@NgModule({
 
  imports: [RouterModule.forRoot(routes)],
  exports:[RouterModule],
})
export class AppRoutingModule { }
