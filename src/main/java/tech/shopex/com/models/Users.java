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
	@Table(name="User")
	public class Users implements Serializable{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="Id",nullable=false,updatable=false)
		private Long Id;
		@Column(name="email",nullable=false,updatable=false,unique=true)
		private String email;
		@Column(name="name")
		private String name;
		@Column(name="password")
		private String password;
		@Column(name="role")
		private String role;
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="fk_cart",referencedColumnName="email")
		private Collection<Cart> carts;
		public Users() {}
		public Users(Long id, String email, String name, String password, String role, Collection<Cart> carts) {
			super();
			Id = id;
			this.email = email;
			this.name = name;
			this.password = password;
			this.role = role;
			this.carts = carts;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		public Collection<Cart> getCarts() {
			return carts;
		}
		public void setCarts(Collection<Cart> carts) {
			this.carts = carts;
		}
		@Override
		public String toString() {
			return "Users [Id=" + Id + ", email=" + email + ", name=" + name + ", password=" + password + ", role="
					+ role + ", carts=" + carts + "]";
		}
		
		
	}