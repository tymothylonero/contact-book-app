package com.contactbook.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.contactbook.model.Contact;

public class FileUtility {
	
	private static final String FILE_PATH = "resources/contacts.data"; 
	
	public static ArrayList<Contact> load() {
		
		File file = new File(FILE_PATH);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error: Could not create file!");
			}
			System.out.println("Info: Created new file: " + FILE_PATH);
			return new ArrayList<Contact>();
		}
		
		try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
			
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("Info: Created new file: " + FILE_PATH);
				return new ArrayList<Contact>();
			} else {
				@SuppressWarnings("unchecked")
				ArrayList<Contact> accounts = (ArrayList<Contact>) reader.readObject();
				return accounts;
			}
			
		} catch(IOException e) {
			System.out.println("Info: Created new file: " + FILE_PATH);
			e.printStackTrace();
			return new ArrayList<Contact>();
		} catch(ClassNotFoundException e) {
			System.out.println("Error: Could not load file!");
		}
		
		return new ArrayList<Contact>();
	}
	
	public static boolean save(ArrayList<Contact> accounts) {
		
		File file = new File(FILE_PATH);
		
		try {
			if(!file.exists())
				file.createNewFile();
		} catch (IOException e) {
			System.out.println("IOException: Could not create file '" + FILE_PATH + "'");
		}
		
		try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
			
			writer.writeObject(accounts);
			
		} catch (IOException e) {
			System.out.println("Error: Could not save file!!!");
		}
		
		return true;
	}

}