package com.cg.greatoutdoors.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.CartDTO;
import com.cg.greatoutdoors.entity.ProductDTO;
import com.cg.greatoutdoors.entity.UserDTO;

@Repository
@Transactional
public class CartDaoImpl implements ICartDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public void addProduct(CartDTO cart) {
		em.persist(cart);
	}

	@Override
	public void deleteProduct(CartDTO cart) {
		System.out.println(cart.getProductId()+" "+cart.getUserId());
		String str="DELETE FROM CartDTO c WHERE c.productId=:productId AND c.userId=:userId";
		Query query=em.createQuery(str);
		query.setParameter("productId", cart.getProductId());
		query.setParameter("userId", cart.getUserId());
		query.executeUpdate();
	}

	@Override
	public List<CartDTO> viewProducts() {
		String str="SELECT cart FROM CartDTO cart";
		TypedQuery<CartDTO> query=em.createQuery(str,CartDTO.class);
		return query.getResultList();
		
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		ProductDTO product = em.find(ProductDTO.class, productId);
		return product;
	}

}
