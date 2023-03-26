import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {


  constructor(private todoService: TodoService){}

  public todo ={
    todoTask:'',
    done:false
  }

  public todos=[
    {
      todoId:0,
      todoTask:'',
      done:false
    }
  ]



  ngOnInit(): void {
    

     this.todoService.getTodoList().subscribe((data:any)=>{
      
      this.todos=data;
      console.log(this.todos);
     },
     (error)=>{
      console.log(error);
     }

  )


/*
this.todoService.getTodoListWebsocket().subscribe(
  (response: any) => {
    this.todos = response;
  },
  (error: any) => {
    console.error(error);
  }
);
/* 
this.todoService.getListWebSocket().subscribe((data) => {
    this.todos = data;
    console.log(this.todos);
  },
  (error)=>{
    console.log(error);
  }
  );
  */

}

  formSubmit(){
  
    if(this.todo.todoTask==''|| this.todo.todoTask==null){
      alert("todo title is required");
      return;
    }
    

    //add todo
    this.todoService.addTodo(this.todo).subscribe(
      (data)=>{
        console.log(data);
        alert('success');
      },
      (error)=>{
        console.log(error);
        alert("got error..");
      }
    )

  }

  //delete todo
 deleteTodo(_tId:Number){

     this.todoService.deleteTodo(_tId).subscribe(
      (data)=>{
        this.todos= this.todos.filter((todoService)=>todoService.todoId!=_tId);
        alert("delete Successfully");
      },
        (error)=>{

          console.log("error is "+error);
          console.log("_tid is : "+_tId);
        }
     )};

     adminDone(todoItem:any){
      this.todoService.isAdminDone(todoItem.done,todoItem.todoId).subscribe(
        ()=>{
          alert("ckecked successfully");
        },
        (error)=>{
          alert(error);
        }
      )
     }
}
