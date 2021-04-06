package model;

import java.io.Serializable;

public class Stock implements Serializable {
	private String productId;
	private String productName;
	private int productStock;
	private int productCost;
	private int productPrice;

	public Stock() {

	}

	public Stock(String productId) {
		this.productId = productId;
	}

	public Stock(String productId, String productName, int productStock, int productCost, int productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productStock = productStock;
		this.productCost = productCost;
		this.productPrice = productPrice;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


}
