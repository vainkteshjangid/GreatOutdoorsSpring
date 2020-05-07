import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Product } from '../Product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  products:Product[];
  cartData:Product[]=[];
  tempProduct:Product;

  constructor(private cartService:CartService) {
    this.getAllProducts();
    for(let product of this.products){
        this.getProductDetail(product.productId);
    };

   }

  ngOnInit() {
  }

  getAllProducts():void{
    this.cartService.loadData().subscribe(data=>
      {
        this.products=data;
      },
      error=>
      {
        console.log("Error occured",error);
      });
  }

  getProductDetail(productId:number):void{
    this.cartService.getProductDetail(productId).subscribe(data=>
      {
          this.tempProduct=data;
          this.cartData.push(this.tempProduct);
      },
      error=>
      {
        console.log("Error occured:"+error);
      });
  }

}
