package model;

import java.io.Serializable;
import java.util.Date;

public class SalesRecord implements Serializable {
	private int number;
	private Date date;
	private String customer;
	private String productId;
	private String productName;
	private int productAmount;
	private int price;

	public SalesRecord() {
	}

	public SalesRecord(int number) {
		this.number = number;
	}

	public SalesRecord(String customer, String productId, String productName, int productAmount, int price) {
		this.customer = customer;
		this.productId = productId;
		this.productName = productName;
		this.productAmount = productAmount;
		this.price = price;
	}

	public SalesRecord(int number, String customer, String productId, String productName, int productAmount,
			int price) {
		this.number = number;
		this.customer = customer;
		this.productId = productId;
		this.productName = productName;
		this.productAmount = productAmount;
		this.price = price;
	}

	public SalesRecord(int number, Date date, String customer, String productId, String productName, int productAmount,
			int price) {
		this.number = number;
		this.date = date;
		this.customer = customer;
		this.productId = productId;
		this.productName = productName;
		this.productAmount = productAmount;
		this.price = productAmount * price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
