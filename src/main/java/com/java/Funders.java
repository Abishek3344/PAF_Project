package com.java;

public class Funders {
	private int funderID;
	private String description;
	private String funderName;
	private String funderNIC;
	private String funderAddress;
	private String Email;
	private String phone;
	private int funder_id;
	
	

	public int getfunderID() {
		return funderID;
	}

	public void setfunderID(int funderID) {
		this.funderID = funderID;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String getfunderName() {
		return funderName;
	}

	public void setfunderName(String funderName) {
		this.funderName = funderName;
	}

	public String getfunderNIC() {
		return funderNIC;
	}

	public void setfunderNIC(String funderNIC) {
		this.funderNIC = funderNIC;
	}

	public String getfunderAddress() {
		return funderAddress;
	}

	public void setfunderAddress(String funderAddress) {
		this.funderAddress = funderAddress;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}


	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}


	public int getUser_id() {
		return funder_id;
	}

	public void setUser_id(int funder_id) {
		this.funder_id = funder_id;
	}

	@Override
	public String toString() {
		
		return "Payment [funderID=" +funderID + " ,description=" + description + ", funderName=" + funderName + ", funderNIC=" + funderNIC
				+ ",funderAddress=" + funderAddress + ",Email=" + Email + ", + phone + \", funder_id=" + funder_id + "]";
	}
}
