import { Component } from '@angular/core';
import { User } from '../assets/user';
import { SessionService } from './session.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Great Outdoors';
  SessionService=SessionService;

  logout():void{
    SessionService.loginStatus=false;
    SessionService.activeUser=null;
  }
}
