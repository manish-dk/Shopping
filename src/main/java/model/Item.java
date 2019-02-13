package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity

public class Item {
	@Id
	@Column(name="itemId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long itemId;
	
	private String name;
	private double price;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "orders_items", joinColumns = { @JoinColumn(name = "orderId") }, inverseJoinColumns = {
//			@JoinColumn(name = "itemId") })
//	private Set<Orders> orders;
	
	

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
//		this.orders = orders;
	}
	
	public Item() {}
	
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

//	public Set<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Orders> orders) {
//		this.orders = orders;
//	}
//	
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
