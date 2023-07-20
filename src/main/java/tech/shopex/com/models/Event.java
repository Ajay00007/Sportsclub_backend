package tech.shopex.com.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="Event")
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id",nullable=false,updatable=false)
	private Long Id;
	@Column(name="name")
	private String name;
	@Column(name="s_date")
	private String s_date;
	@Column(name="e_date")
	private String e_date;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_coupon",referencedColumnName = "Id")
	private Collection<Coupons> coupon;
	
	public Event() {
		super();
	}

	public Event(Long id, String name, String s_date, String e_date, Collection<Coupons> coupon) {
		super();
		Id = id;
		this.name = name;
		this.s_date = s_date;
		this.e_date = e_date;
		this.coupon = coupon;
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

	public Collection<Coupons> getCoupon() {
		return coupon;
	}

	public void setCoupon(Collection<Coupons> coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "Event [Id=" + Id + ", name=" + name + ", s_date=" + s_date + ", e_date=" + e_date + ", coupon=" + coupon
				+ "]";
	}

	
}