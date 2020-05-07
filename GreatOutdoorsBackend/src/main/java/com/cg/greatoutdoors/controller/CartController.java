package com.cg.greatoutdoors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.greatoutdoors.entity.CartDTO;
import com.cg.greatoutdoors.entity.ProductDTO;
import com.cg.greatoutdoors.entity.UserDTO;
import com.cg.greatoutdoors.exception.RecordNotFoundException;
import com.cg.greatoutdoors.entity.CartCompositePK;
import com.cg.greatoutdoors.service.ICartService;
import com.cg.greatoutdoors.service.CartServiceImpl;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CartController {
	
	@Autowired
	ICartService cartService;
	
/*********************************************************************************************************
     *Method:                  - addProduct
     *description:             - adds product in the cart               - 
     *@returns                 - ResponseEntity
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@PostMapping(value="/cart/newProd", consumes="application/json")
	public ResponseEntity<CartDTO> addToCart(@RequestBody CartDTO newItem) {
		
		cartService.addProduct(newItem);
		return new ResponseEntity<CartDTO>(newItem,HttpStatus.OK);
	}
	
	
/*********************************************************************************************************
     *Method:                  - removeFromCart
     *description:             - delete product form the cart               - 
     *@returns                 - String message
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@DeleteMapping(value="/cart/deleteProd")
	public String removeFromCart(@RequestBody CartDTO cartItem) {
		cartService.deleteProduct(cartItem);
		return "Item removed from cart";
	}
	
	
/*********************************************************************************************************
     *Method:                  - viewProducts
     *description:             - fetch all cart products from database              - 
     *@returns                 - List of cart products
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@GetMapping(value="/cart/viewCart",produces="application/json")
	public List<CartDTO> viewCart() {
		return cartService.viewProducts();
	}
	
/*********************************************************************************************************
     *Method:                  - getProductById
     *description:             - fetch product of given id from database            - 
     *@returns                 - Product of given productId
     *@throws                  - 
     *created by               - Vainktesh Prasad Jangid
     *created date             - 26/4/2020
**********************************************************************************************************/
	@GetMapping(value="cart/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable("productId") @RequestParam Long productId){
		ProductDTO product=cartService.getProductById(productId);
		
		if(product==null) {
			throw new RecordNotFoundException("Invalid product id : "+productId);
		}
		return new ResponseEntity<ProductDTO>(product,HttpStatus.OK);
	}
}
