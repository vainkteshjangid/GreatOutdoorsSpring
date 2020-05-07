package com.cg.greatoutdoors.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(CartCompositePK.class)
@Table(name="CART_GO")
public class CartDTO implements Serializable{
	@Id
	//@NotNull(message="Product id can not be null")
	private Long productId;
	
	@Id
	//@NotNull(message="User id can not be null")
	private Long userId;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(Long productId, Long userId, int quantity) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
