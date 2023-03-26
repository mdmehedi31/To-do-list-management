// <reference types="@types/stompjs" />


import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { webSocket,WebSocketSubject } from 'rxjs/webSocket';
import { Client } from '@stomp/stompjs';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  stompClient: any;

  
  
  constructor(private http:HttpClient) {
    /*
    const ws=new WebSocket('ws:/localhost:8082/ws');
    const stompClient= new Client();
    this.stompClient.webSocketFactory = () => ws;
    this.stompClient.activate();
 
*/

   }

  //add todo
  public addTodo(todo:any){
 
    //352 is ADMIN user id, please add your own id which will generate
    return this.http.post(`${baseUrl}/todo/add/`+352,todo);
  }

  

/*
  getListWebSocket() {
    const subject = new Subject<any>();
    const subscription = this.stompClient.subscribe('/topic/messages', (message:any) => {
      const data = JSON.parse(message.body);
      subject.next(data);
      subscription.unsubscribe();
    });
    this.stompClient.publish({ destination: '/app/todo/get' });
    return subject.asObservable();
  }
  
*/
// get todoList
  public getTodoList(){

    return this.http.get(`${baseUrl}/todo/get`);
  }

  //delete todo
  //352 is ADMIN user id, please add your own id which will generate
  public deleteTodo(_tId:Number){
    return this.http.delete(`${baseUrl}/todo/delete/`+352+`/${_tId}`);
  }
}
