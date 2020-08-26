package bankapp.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;



public class userSignupInfo {
	
	
	
	@NotNull
	private String first_name;
	
	
	@NotBlank(message = "should have some value")
	private String last_name;
	
	@NotBlank(message = "should have some value")
	@Column(name="username",nullable = false,unique = true)
	private String username;
	
	@MinLength(limit = 8,message = "Minimum length required is eight ")
	private String password;
	
	@NotNull(message = "should have some value")
	@Size(min = 10,max = 10,message = "number should be 10 digits")
	private String phone;
	
	@Email(message = "Incorrect email address")
	private String email;
	
	
	@NotBlank(message = "please enter valid value")
	private String address;
	
	@NotBlank(message = "please enter valid value")
	private String city;
	
	
	@NotBlank(message = "please enter valid value")
	private String state;
	
	@NotBlank(message = "please enter valid value")
	private String country;
	
	@NotBlank(message = "please enter valid value")
	private String zip;
	
	@NotBlank(message = "please enter valid value")
	private String Id_name;
	
	@NotBlank(message = "please enter valid value")
	private String Id_number;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getId_name() {
		return Id_name;
	}

	public void setId_name(String id_name) {
		Id_name = id_name;
	}

	public String getId_number() {
		return Id_number;
	}

	public void setId_number(String id_number) {
		Id_number = id_number;
	}

	@Override
	public String toString() {
		return "userSignupInfo [first_name=" + first_name + ", last_name=" + last_name + ", username=" + username
				+ ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", zip=" + zip + ", Id_name="
				+ Id_name + ", Id_number=" + Id_number + "]";
	}
	
	
	

}
