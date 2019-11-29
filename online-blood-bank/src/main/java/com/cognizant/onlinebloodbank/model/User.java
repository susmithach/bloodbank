package com.cognizant.onlinebloodbank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="user")
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
private int id;
	@NotNull
	@Column(name="username")
	private String username;
	
	@NotNull
	@Column(name="fname")
private String firstname;
	@NotNull
	@Column(name="lname")
private String lastname;
	@NotNull
	@Column(name="age")
private int age;
	@NotNull
	@Column(name="gender")
private String gender;
	@NotNull
	@Column(name="email")
private String email;
	@NotNull
	@Column(name="state")
private String state;
	@NotNull
	@Column(name="area")
private String area;
	@NotNull
	@Column(name="password")
private String password;
	@NotNull
	@Column(name="pincode")
private int pincode;
	@NotNull
	@Column(name="bgroup")
private String bloodgroup;
	@NotNull
	@Column(name="weight")
private int weight;
	@NotNull
	@Column(name="cnumber")
private String contactnumber;
	@JsonIgnore
	@ManyToMany
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
 private List<Role> roles;
	public List<Role> getRoles() {
		return roles;
	}
	@OneToMany(mappedBy="userid",cascade = CascadeType.ALL)
	private List<Request> requests;
	@OneToOne(mappedBy="userId",cascade = CascadeType.ALL)
	private Donate donate;
	public List<Request> getRequests() {
		return requests;
	}

	public Donate getDonate() {
		return donate;
	}

	public void setDonate(Donate donate) {
		this.donate = donate;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", email=" + email + ", state=" + state + ", area=" + area + ", password=" + password
				+ ", pincode=" + pincode + ", bloodgroup=" + bloodgroup + ", weight=" + weight + ", contactnumber="
				+ contactnumber + "]";
	}




}
