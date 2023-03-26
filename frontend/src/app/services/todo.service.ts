import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http:HttpClient) { }

  //add todo

  public addTodo(todo:any){

    return this.http.post(`${baseUrl}/todo/add/`+202,todo);
  }

  // get todoList

  public getTodoList(){

    return this.http.get(`${baseUrl}/todo/get`);
  }

  //delete todo

  public deleteTodo(_tId:Number){
    return this.http.delete(`${baseUrl}/todo/delete/`+202+`/${_tId}`);
  }
}
