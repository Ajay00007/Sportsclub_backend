package tech.shopex.com.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id",nullable=false,updatable=false)
	private Long Id;
	@Column(name="email")
	private String email;
	@Column(name="item_id")
	private String item_id;
	@Column(name="name")
	private String name;
	@Column(name="images")
	private String images;
	@Column(name="cost")
	private double cost;
	@Column(name="details")
	private String details;
	@Column(name="count")
	private int count;
	
	public Cart() {
		super();
	}

	public Cart(Long id, String email, String item_id, String name, String images, double cost, String details, int count) {
		super();
		Id = id;
		this.email = email;
		this.item_id = item_id;
		this.name = name;
		this.images = images;
		this.cost = cost;
		this.details = details;
		this.count = count;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Cart [Id=" + Id + ", email=" + email + ", item_id=" + item_id + ", name=" + name + ", images=" + images
				+ ", cost=" + cost +  ", details=" + details + ", count=" + count + "]";
	}
	

	
}
