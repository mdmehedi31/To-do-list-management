import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { LoginComponent } from './pages/login/login.component';
import { AppRoutingModule } from './app-routing.module';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { UserComponent } from './admin/usertask/user.component';
import {HttpClientModule} from '@angular/common/http';
import { TodoComponent } from './admin/todo/todo.component'
import { FormsModule } from '@angular/forms';
import { Todo1Component } from './admin/todo1/todo1.component';
import { Users1Component } from './Users/users1/users1.component';
import { PanelComponent } from './admin/panel/panel.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    TodoComponent,
    Todo1Component,
    Users1Component,
    PanelComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
