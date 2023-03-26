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
}
