package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	
	private String date;
	private double price;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
//	@ManyToMany(fetch = FetchType.LAZY)
//	private Set<Item> items = new HashSet<>();

	public Orders(String date, double price, User user) {
		super();
		this.date = date;
		this.price = price;
		this.user = user;
	}
	
	public Orders() {}
	
	
//	public void addItem(Item item) {
//		items.add(item);
//	}
//
//	public Set<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(Set<Item> items) {
//		this.items = items;
//	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
