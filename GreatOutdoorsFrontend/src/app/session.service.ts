import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

   static loginStatus:boolean;
   static activeUser:User;

   Session=SessionService;

  constructor() { }



}
