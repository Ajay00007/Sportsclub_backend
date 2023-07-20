package tech.shopex.com.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id",nullable=false,updatable=false)
	private Long Id;
	@Column(name="name",unique = true)
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="category",referencedColumnName="name")
	private Collection<Products> products;
	@Override
	public String toString() {
		return "Category [Id=" + Id + ", name=" + name + ", products=" + products + "]";
	}
	public Category(Long id, String name, Collection<Products> products) {
		super();
		Id = id;
		this.name = name;
		this.products = products;
	}
	public Category() {
		super();
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
	public Collection<Products> getProducts() {
		return products;
	}
	public void setProducts(Collection<Products> products) {
		this.products = products;
	}
	

}
