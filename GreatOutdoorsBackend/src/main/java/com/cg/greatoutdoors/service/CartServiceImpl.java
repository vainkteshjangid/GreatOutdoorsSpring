package com.cg.greatoutdoors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.dao.ICartDao;
import com.cg.greatoutdoors.dao.CartDaoImpl;
import com.cg.greatoutdoors.entity.CartDTO;
import com.cg.greatoutdoors.entity.ProductDTO;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	ICartDao dao=new CartDaoImpl();

	@Override
	public void addProduct(CartDTO cart) {
		dao.addProduct(cart);
	}

	@Override
	public void deleteProduct(CartDTO cart) {
		dao.deleteProduct(cart);
	}
	
	@Override
	public List<CartDTO> viewProducts() {
		return dao.viewProducts();
		
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		return dao.getProductById(productId);
	}
	

}
