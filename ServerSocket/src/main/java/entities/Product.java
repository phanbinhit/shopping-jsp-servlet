package entities;

import java.util.Objects;

public class Product {
	private int id;
	private String title;
	private String branch;
	private int quantity;
	private double price;
	public Product(String title, double price) {
		this.title = title;
		this.price = price;
	}
	public Product(int id, String title, String branch, int quantity, double price) {
		super();
		this.id = id;
		this.title = title;
		this.branch = branch;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getNumber() {
		return quantity;
	}
	public void setNumber(int number) {
		this.quantity = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Product)) {
			return false;
		}
		Product that = (Product) obj;
		return getId() == that.getId();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", branch=" + branch + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
}
