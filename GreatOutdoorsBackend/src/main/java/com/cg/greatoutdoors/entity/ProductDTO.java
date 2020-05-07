package com.cg.greatoutdoors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_GO")
public class ProductDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="PRODUCT_ID_GENERATOR")
	@SequenceGenerator(name="PRODUCT_ID_GENERATOR",sequenceName="PRODUCT_SEQUENCE",initialValue=20001)
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="COLOUR")
	private String colour;
	
	@Column(name="DIMENSION")
	private String dimension;
	
	@Column(name="SPECIFICATION")
	private String specification;
	
	@Column(name="MANUFACTURER")
	private String manufacturer;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="PRODUCT_CATEGORY")
	private int productCategory;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	
	

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String productName,double price, String colour,int productCategory, String dimension, String specification, String manufacturer,
			int quantity) {
		super();
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
