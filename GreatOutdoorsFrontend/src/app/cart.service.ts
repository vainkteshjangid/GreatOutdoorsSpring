import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient) { }

  loadData():Observable<any>{
    let url='http://localhost:1136/cart/viewCart';
    return this.http.get(url);
  }

  getProductDetail(productId:number):Observable<any>{
   
    let url=`http://localhost:1136/cart/${productId}`;
    return this.http.get(url,{responseType:"json"});
  }
  
}
