package com.cognizant.onlinebloodbank.model;




import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="slot")
public class Slot {
	@Id
	@Column(name="so_id")
private int so_id;
	@Column(name="hospital")
	@NotNull
private String hospital;
	@NotNull
	@Column(name="city")
private String city;
	@NotNull
	@Column(name="date")
private Date date;
	@Column(name="time")
	@NotNull
private String time;
public int getSo_id() {
	return so_id;
}
@OneToOne()
@JoinColumn(name="so_id")
private Donate donateid;
public void setSo_id(int so_id) {
	this.so_id = so_id;
}
public String getHospital() {
	return hospital;
}
public void setHospital(String hospital) {
	this.hospital = hospital;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}




}
