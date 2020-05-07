import { Injectable } from '@angular/core';
import { User } from '../assets/user';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

   static loginStatus:boolean;
   static activeUser:User;

   Session=SessionService;

  constructor() { }



}
