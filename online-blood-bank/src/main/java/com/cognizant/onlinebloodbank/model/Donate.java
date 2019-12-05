package com.cognizant.onlinebloodbank.model;

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
@Table(name="donate")
public class Donate {
	@Id
	@Column(name="do_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int do_id;
	@NotNull
	@Column(name="do_bgroup")
private String bloodgroup;
	@NotNull
	@Column(name="do_state")
private String state;
	@NotNull
	@Column(name="do_area")
private String area;
	@NotNull
	@Column(name="do_cnumber")
	private String contactnumber;
	@NotNull
    @Column(name="do_pincode")
	private int pincode;

	@OneToOne
	@JoinColumn(name="do_us_fk")
	private User userId;
	
	
@OneToOne(mappedBy="donateid",cascade = CascadeType.ALL,orphanRemoval=true)
private Slot slotid;

public Slot getSlotid() {
	return slotid;
}

public void setSlotid(Slot slotid) {
	this.slotid = slotid;
}



	public int getPincode() {
	return pincode;
}



public void setPincode(int pincode) {
	this.pincode = pincode;
}



	public int getDo_id() {
		return do_id;
	}

	public void setDo_id(int do_id) {
		this.do_id = do_id;
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

	/*public User getUserId() {
		return userId;
	}*/

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
}
