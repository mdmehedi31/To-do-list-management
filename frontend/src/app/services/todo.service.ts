// <reference types="@types/stompjs" />


import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TodoService {
  stompClient: any;

  
  
  constructor(private http:HttpClient) {}

  //add todo

  public addTodo(todo:any){

    return this.http.post(`${baseUrl}/todo/add/`+202,todo);
  }

  // get todoList


  public getTodoListWebsocket(): Observable<any> {
    const subject = webSocket(`${baseUrl}/todo/get`);

    return subject.asObservable();
  }
  
  
/*
  public getTodoList(){

    return this.http.get(`${baseUrl}/todo/get`);
  }
*/
  //delete todo

  public deleteTodo(_tId:Number){
    return this.http.delete(`${baseUrl}/todo/delete/`+202+`/${_tId}`);
  }
}
