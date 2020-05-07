package com.cg.greatoutdoors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.entity.CartDTO;
import com.cg.greatoutdoors.entity.ProductDTO;
import com.cg.greatoutdoors.entity.CartCompositePK;

@Service
public interface ICartService {
	
	public void addProduct(CartDTO cart);
	
	public void deleteProduct(CartDTO cartItem);
	
	public List<CartDTO> viewProducts();

	public ProductDTO getProductById(Long productId);
}
