package com.cg.greatoutdoors.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.CartDTO;
import com.cg.greatoutdoors.entity.ProductDTO;

@Repository
@Transactional
public interface ICartDao {
	
	public void addProduct(CartDTO cart);
	
	public void deleteProduct(CartDTO cart);
	
	public List<CartDTO> viewProducts();

	public ProductDTO getProductById(Long productId);
}
