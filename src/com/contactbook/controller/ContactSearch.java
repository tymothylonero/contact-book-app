package com.contactbook.controller;

import com.contactbook.application.ContactBookApplication;
import com.contactbook.model.Contact;

public class ContactSearch {

	public static String searchByName(String name) {
		
		String contactsFound = "";
		
		for(Contact c : ContactBookApplication.contacts) {
			if(c.getName().contains(name)) {
				contactsFound = contactsFound + c.toString();
			}
		}
		
		return contactsFound;
	}
	
	public static String searchByTag(String tag) {
		
		String contactsFound = "";
		
		for(Contact c : ContactBookApplication.contacts) {
			if(c.getTags().contains(tag)) {
				contactsFound = contactsFound + c.toString();
			}
		}
		
		return contactsFound;
	}
	
}
