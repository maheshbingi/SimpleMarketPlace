package com.lab2.SimpleMarketPlace.Models;

public class UserSellHistory {
	String product_name;
	String description;
	String seller_info;
	int cost;
	int quantity;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSeller_info() {
		return seller_info;
	}
	public void setSeller_info(String seller_info) {
		this.seller_info = seller_info;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
