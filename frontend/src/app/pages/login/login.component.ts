import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{


  loginData={
    userName:'',
    password:''
  };

  constructor(private snack: MatSnackBar, private loginService:LoginService){
  }

  ngOnInit(): void {
   
  }

  formSubmit(){
    console.log('login btn clicked');

    if(this.loginData.userName.trim()=='' ||
    this.loginData.userName==null){
       
       this.snack.open('Username is required!!','',{
        duration:3000,
       });

       return;
    }

    if(this.loginData.password.trim()=='' ||
    this.loginData.password==null){
       
       this.snack.open('Password is required!!','',{
        duration:3000,
       });

       return;
    }

    //generate token


    this.loginService.generateToken(this.loginData).subscribe(

      (data:any)=>{
        console.log("success");
        console.log(data);
      },
      (error)=>{
        console.log("Error !!...");
        console.log(error);
      }
    )

  }
}
