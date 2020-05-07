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
	
	@PostMapping(value="/cart/newProd", consumes="application/json")
	public ResponseEntity<CartDTO> addToCart(@RequestBody CartDTO newItem) {
		
		cartService.addProduct(newItem);
		return new ResponseEntity<CartDTO>(newItem,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/cart/deleteProd")
	public String removeFromCart(@RequestBody CartDTO cartItem) {
		cartService.deleteProduct(cartItem);
		return "Item removed from cart";
	}
	
	@GetMapping(value="/cart/viewCart",produces="application/json")
	public List<CartDTO> viewCart() {
		return cartService.viewProducts();
	}
	
	@GetMapping(value="cart/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable("productId") @RequestParam Long productId){
		ProductDTO product=cartService.getProductById(productId);
		
		if(product==null) {
			throw new RecordNotFoundException("Invalid product id : "+productId);
		}
		return new ResponseEntity<ProductDTO>(product,HttpStatus.OK);
	}
}
