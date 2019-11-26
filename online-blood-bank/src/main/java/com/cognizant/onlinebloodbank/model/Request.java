package com.cognizant.onlinebloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="request")
public class Request {
	@Id
	@Column(name="re_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@NotNull
	@Column(name="re_bgroup")
private String bloodgroup;
	@NotNull
	@Column(name="re_state")
private String state;
	@NotNull
	@Column(name="re_area")
private String area;
	@NotNull
	@Column(name="re_cnumber")
private String contactnumber;
	@ManyToOne()
	@JoinColumn(name="re_us_fk")
	private User userid;
	
/*public User getUserid() {
		return userid;
	}*/
	public void setUserid(User userid) {
		this.userid = userid;
	}
public String getBloodgroup() {
	return bloodgroup;
}
public void setBloodgroup(String bloodgroup) {
	this.bloodgroup = bloodgroup;
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
public String getContactnumber() {
	return contactnumber;
}
public void setContactnumber(String contactnumber) {
	this.contactnumber = contactnumber;
}

}
