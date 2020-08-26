package bankapp.DAO;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_user_profile",schema = "banking")

public class SignupData {
	
	@Id
	@Column(name="profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profile_id;
	
	private String first_name;
	
	
	private String last_name;
	
	
	@Column(name="username",nullable = false,unique = true)
	private String username;
	
	@Column(name="password",nullable = false,unique = true)
	private String password;
	
	@Column(name="phone",nullable = false,unique = true)
	private String phone;
	
	@Column(name="email",nullable = false,unique = true)
	private String email;
	
	
	
	private String address;
	
	
	
	private String city;
	
	
	
	private String state;
	
	
	private String country;
	
	private String zip;
	
	private String id_name;
	
	private String id_number;
	
	
	@Column(name = "created_time")
	private Timestamp created_time;
	
	@Column(name = "updated_time",nullable = false)
	private Timestamp updated_time;

	
	
	
	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

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
		return id_name;
	}

	public void setId_name(String id_name) {
		this.id_name = id_name;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

	public Timestamp getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Timestamp updated_time) {
		this.updated_time = updated_time;
	}

	@Override
	public String toString() {
		return "SignupData [profile_id=" + profile_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", username=" + username + ", password=" + password.trim().length() + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", zip="
				+ zip + ", id_name=" + id_name + ", id_number=" + id_number + ", created_time=" + created_time
				+ ", updated_time=" + updated_time + "]";
	}
	
	
	

	
	
}
