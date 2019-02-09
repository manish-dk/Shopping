package model;

import javax.persistence.*;
@Entity

public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long itemId;
	
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public Item() {
	
	}
	
	public String toString() {
		return String.format("Item[id=%d,name'%s',price=%d]",itemId,name,price);
	}
	
	public Long getId() {
		return itemId;
	}
	public void setId(Long id) {
		this.itemId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
