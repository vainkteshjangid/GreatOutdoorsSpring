import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Product } from '../../assets/Product';
import { Cart } from '../../assets/Cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
   products:Array<Cart>=[];
  cartData:Array<Product>=[];
  tempProduct:Product;

  constructor(private cartService:CartService) {
    this.getAllProducts();
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

}
