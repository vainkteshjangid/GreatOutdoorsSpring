package com.cg.greatoutdoors.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_GO")
public class OrderDTO {
	@Id
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="ADDRESS_ID")
	private Long addressId;
	
	@Column(name="ORDER_DISPATCH_STATUS")
	private byte orderDispatchStatus;
	
	@Column(name="ORDER_INITIATE_TIME")
	private Date orderInitiateTime;
	
	@Column(name="ORDER_DISPATCH_TIME")
	private Date orderDispatchTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public byte getOrderDispatchStatus() {
		return orderDispatchStatus;
	}

	public void setOrderDispatchStatus(byte orderDispatchStatus) {
		this.orderDispatchStatus = orderDispatchStatus;
	}

	public Date getOrderInitiateTime() {
		return orderInitiateTime;
	}

	public void setOrderInitiateTime(Date orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}

	public Date getOrderDispatchTime() {
		return orderDispatchTime;
	}

	public void setOrderDispatchTime(Date orderDispatchTime) {
		this.orderDispatchTime = orderDispatchTime;
	}
	
	

}
