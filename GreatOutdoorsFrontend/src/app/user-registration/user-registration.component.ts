import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  user:User=new User();
  cnfPassword:String;

  constructor(private userService:UserService) { }

  ngOnInit() {
  }

  create():void{
    this.userService.create(this.user).subscribe(data=>
      {
        alert("User successfully registered!");
      },
      error=>
      {
        console.log("error occured",error.getMessage());
      }
    );
  }

}
