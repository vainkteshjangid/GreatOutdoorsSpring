import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { SessionService } from '../session.service';
import { User } from '../user';
import { HttpErrorResponse } from '@angular/common/http';
import { AppComponent } from '../app.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  component:AppComponent;


  username:string;
  password:string;

  constructor(private userService:UserService,private router:Router) { }

  ngOnInit() {
  }

  onFormSubmit():void{
       this.userService.login(this.username,this.password).subscribe(data=>{
      SessionService.activeUser=data;
      SessionService.loginStatus=true;
      console.log(SessionService.activeUser.username+' logged in successfully,'+SessionService.loginStatus);
      this.router.navigateByUrl('');
    },
    (error:HttpErrorResponse)=>{
      console.log("error occured:",error);

    })
  }

}
