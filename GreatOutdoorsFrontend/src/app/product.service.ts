import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../assets/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url: string = "http://localhost:1136/";
  constructor(private httpClient: HttpClient) { }

  addProduct(productMasterId:number,productDto: Product) {

    return this.httpClient.post(this.url + "addproduct/"+productMasterId, productDto, { headers: { 'Content-Type': 'application/json' } });
  }



  getProductsWhichBelongsToParticularProductMaster(productMasterId: number, pageNumber: number) {
    return this.httpClient.get(this.url + "getproductsofproductmaster/" + productMasterId + "/" + pageNumber);
  }

  getProductById(productId: number) {
    return this.httpClient.get(this.url + "getproductbyid/" + productId);
  }
  updateProduct(productMasterId:number,product: Product) {
    return this.httpClient.put(this.url + "updateproduct/"+productMasterId, product);
  }
  deleteProduct(productMasterId:number,productId: number) {
    return this.httpClient.delete(this.url + "deleteproduct/" +productMasterId+"/"+productId);
  }
  getAllProducts(userId:number,pageNumber: number) {
    return this.httpClient.get(this.url + "getproductsofuser/"+userId+"/" + pageNumber);
  }


  searchProduct(searchKeyword: string, pageNumber: number) {
    return this.httpClient.get(this.url + "searchproduct/" + searchKeyword + "/" + pageNumber);
  }
}


