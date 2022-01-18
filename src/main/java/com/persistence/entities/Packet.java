package com.persistence.entities;

public class Packet {
	
	private Product product;
	private int units;
	private Float price;
	
	
	public Packet(Product product, int units, Float price) {
		super();
		this.product = product;
		this.units = units;
		this.price = price;
		
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}
