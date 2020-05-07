import { Component, OnInit } from '@angular/core';
import { User } from '../../assets/user';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';
import { SessionService } from '../session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  allUsers=[];
  constructor(private userService:UserService,private router:Router) { 
    this.getAllUser();
  }

  ngOnInit() {
    if(SessionService.loginStatus && SessionService.activeUser.role=="Admin"){
        
    }
    else {
      this.router.navigateByUrl('#');
    }
  }

  getAllUser():void{
    this.userService.loadData().subscribe(data=>
      {
        this.allUsers=data;
      },
      error=>
      {
        console.log("Error occured",error);
      });
  }

  deleteUser(user:User,i:number):void{
    this.allUsers.splice(i,1);
    this.userService.deleteUser(user.userId).subscribe(data=>
      {
        console.log("User deleted succesfully");
      },
      error=>
      {
        console.log("Error occured",error);
      })
  }

}
