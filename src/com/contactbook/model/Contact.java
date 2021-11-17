package com.contactbook.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String phoneNumber;
	private String email;
	private Date dob;
	private String address;
	private ArrayList<WebLink> links;
	private String tags;
	
	public Contact(String name, String description, String phoneNumber, String email, Date dob, String address, String tags) {
		this.name = name;
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.tags = tags;
	}
	
	public Contact() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<WebLink> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<WebLink> links) {
		this.links = links;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Name: " + name 
				+ "\nDescription: " + description
				+ "\nNumber: " + phoneNumber
				+ "\nEmail: " + email
				+ "\nBirthday: " + dob
				+ "\nAddress: " + address
				+ "\nLinks: " + links
				+ "\nTags: " + tags + "\n\n";
	}
	
}
