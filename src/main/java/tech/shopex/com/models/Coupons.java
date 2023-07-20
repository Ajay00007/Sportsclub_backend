package tech.shopex.com.models;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coupons")
public class Coupons implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id",nullable=false,updatable=false)
	private Long Id;
	@Column(name="name",unique=true)
	private String name;
	@Column(name="discount")
	private double discount;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "Coupons{" +
				"Id=" + Id +
				", name='" + name + '\'' +
				", discount=" + discount +
				", s_date='" + s_date + '\'' +
				", e_date='" + e_date + '\'' +
				'}';
	}

	public Coupons(Long id, String name, double discount, String s_date, String e_date) {
		Id = id;
		this.name = name;
		this.discount = discount;
		this.s_date = s_date;
		this.e_date = e_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getE_date() {
		return e_date;
	}

	public void setE_date(String e_date) {
		this.e_date = e_date;
	}

	@Column(name="s_date")
	private String s_date;

	@Column(name="e_date")
	private String e_date;
	public Coupons() {
	}


}
