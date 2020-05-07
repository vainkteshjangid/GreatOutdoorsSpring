import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpErrorResponse} from '@angular/common/http';
import { Observable, from, throwError } from 'rxjs';
import { User } from './user';
import {catchError} from 'rxjs/operators';
import { SessionService } from './session.service';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  users:User[]=[];

  constructor(private http:HttpClient) { }

  loadData():Observable<any>{
    let url='http://localhost:1136/user/viewAll';
    return this.http.get(url);
  }

  create(user:User):Observable<any>{
    let url='http://localhost:1136/user/newUser';
    return this.http.post(url,user,{responseType:"text"});
  }

  login(username:string,password:string):Observable<any> {
    let myParams = new HttpParams({fromObject:{username:username,password:password}});
  
    let url='http://localhost:1136/user/login';
    return this.http.get(url,{params:myParams}).pipe(catchError(this.handleError));

  }

  deleteUser(userId:number):Observable<any> {
    let url=`http://localhost:1136/user/deleteUser/${userId}`;
    
    return this.http.delete(url,{responseType:"text"});
  }

  handleError(error:HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = `Error: ${error.error.message}`;
      console.log(errorMessage);
    } else {
      // server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
   // window.alert(errorMessage);
    return throwError(errorMessage);
  }
}
