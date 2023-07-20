package tech.shopex.com.models;

public class Singin {
	String email;
	String password;
	public Singin() {
		super();
	}
	public Singin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmial(String emial) {
		this.email = emial;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
