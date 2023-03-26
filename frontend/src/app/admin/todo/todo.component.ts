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

  ngOnInit(): void {
    
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


}
