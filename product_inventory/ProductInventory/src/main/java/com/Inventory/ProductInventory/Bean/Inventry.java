package com.Inventory.ProductInventory.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Inventry")
public class Inventry {

	@Id
	private int id;
	private String product;
	private int quantity_purchase;
	private int quantity_instock;
	private int unit_price;
	
	
	public Inventry() {
		
	}

	public Inventry(int id, String product, int quantity_purchase, int quantity_instock, int unit_price) {
		super();
		this.id = id;
		this.product = product;
		this.quantity_purchase = quantity_purchase;
		this.quantity_instock = quantity_instock;
		this.unit_price = unit_price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity_purchase() {
		return quantity_purchase;
	}

	public void setQuantity_purchase(int quantity_purchase) {
		this.quantity_purchase = quantity_purchase;
	}

	public int getQuantity_instock() {
		return quantity_instock;
	}

	public void setQuantity_instock(int quantity_instock) {
		this.quantity_instock = quantity_instock;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	
	
}
