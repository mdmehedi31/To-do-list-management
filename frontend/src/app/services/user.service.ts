import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }


  //get todo list
  public getList(){
    return this.http.get(`${baseUrl}/todo/get`);
  }

  public isDone(isChecked:boolean,todoId:Number){

    return this.http.post(`${baseUrl}/todo/done/`+353+`/${todoId}`,isChecked);
  }
}

