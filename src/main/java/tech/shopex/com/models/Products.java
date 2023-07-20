package tech.shopex.com.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Products implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id",nullable=false,updatable=false)
	private Long Id;
	@Column(name="name")
	private String name;
	@Column(name="details")
	private String details;
	@Column(name="cost")
	private double cost;
	@Column(name="images")
	private String images;
	
	public Products(Long id, String name, String details, double cost,String images) {
		super();
		Id = id;
		this.name = name;
		this.details = details;
		this.cost = cost;
		this.images = images;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}


	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}


	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Products() {
		super();
	}

	@Override
	public String toString() {
		return "Products [Id=" + Id + ", name=" + name + ", details=" + details + ", cost="
				+ cost + ",images=" + images + "]";
	}
	

}
