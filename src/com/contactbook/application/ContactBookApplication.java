package com.contactbook.application;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.contactbook.controller.ContactSearch;
import com.contactbook.model.Contact;
import com.contactbook.utility.FileUtility;

public class ContactBookApplication {
	
	public static ArrayList<Contact> contacts;

	public static void main(String[] args) {
		
		contacts = FileUtility.load();
		
		JFrame frame = new JFrame("Contact Book Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu m2 = new JMenu("Help");
        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(viewMenu);
        mb.add(m2);
        JMenuItem fileMenu1 = new JMenuItem("Open");
        JMenuItem saveContacts = new JMenuItem("Save");
        JMenuItem addContact = new JMenuItem("Add...");
        JMenuItem viewAll = new JMenuItem("View all");
        JMenuItem viewNames = new JMenuItem("View names");
        fileMenu.add(fileMenu1);
        fileMenu.add(saveContacts);
        editMenu.add(addContact);
        viewMenu.add(viewAll);
        viewMenu.add(viewNames);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel();
        JLabel nameSearchLabel = new JLabel("Search by name");
        JTextField nameSearchText = new JTextField(10);
        JButton nameSearch = new JButton("Search");
        panel.add(nameSearchLabel);
        panel.add(nameSearchText);
        panel.add(nameSearch);
        
        JLabel tagSearchLabel = new JLabel("Search by tag");
        JTextField tagSearchText = new JTextField(10);
        JButton tagSearch = new JButton("Search");
        panel.add(tagSearchLabel);
        panel.add(tagSearchText);
        panel.add(tagSearch);
        
        JButton randomSearch = new JButton("Random");
        panel.add(randomSearch);

        // Text Area at the Center
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        ta.setText("Welcome!\nGo into View to view all or use the search bar!");
        JScrollPane test = new JScrollPane(ta);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, test);
        frame.setVisible(true);
        
        nameSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
							
				if(!nameSearchText.getText().equals("")) {
					ta.setText(ContactSearch.searchByName(nameSearchText.getText()));
				}
				
			}
		});
        
        tagSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
							
				if(!tagSearchText.getText().equals("")) {
					ta.setText(ContactSearch.searchByTag(tagSearchText.getText()));
				}
				
			}
		});
        
        saveContacts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean saved = FileUtility.save(contacts);
				JOptionPane.showMessageDialog(saveContacts, "Saved contacts to file. " + saved);
				
			}
		});
     
        addContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame newContact = new JFrame("Add a contact");
				newContact.setSize(400, 225);
				GridLayout layout = new GridLayout(8,2);
				newContact.setLayout(layout);
				
				JTextField addName = new JTextField(25);
				JTextField addDesc = new JTextField(25);
				JTextField addNumb = new JTextField(25);
				JTextField addEmail = new JTextField(25);
				JTextField addDOB = new JTextField(25);
				JTextField addAddress = new JTextField(25);
				JTextField addTags = new JTextField(25);
				
				newContact.add(new JLabel("Name: "));
				newContact.add(addName);
				newContact.add(new JLabel("Description: "));
				newContact.add(addDesc);
				newContact.add(new JLabel("Number: "));
				newContact.add(addNumb);
				newContact.add(new JLabel("Email: "));
				newContact.add(addEmail);
				newContact.add(new JLabel("DOB: "));
				newContact.add(addDOB);
				newContact.add(new JLabel("Address: "));
				newContact.add(addAddress);
				newContact.add(new JLabel("Tags: "));
				newContact.add(addTags);
				
				JButton submit = new JButton("Add");
				
				newContact.add(new JLabel(""));
				newContact.add(submit);
				
		        newContact.setVisible(true);
		        
		        submit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						contacts.add(new Contact(
								addName.getText(),
								addDesc.getText(),
								addNumb.getText(),
								addEmail.getText(),
								//addDOB.getText(),
								null,
								addAddress.getText(),
								addTags.getText()
								));
						newContact.setVisible(false);
						
					}
				});
				
			}
		});
        
        viewAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String contactList = "";
				
				for(Contact c : contacts) {
					contactList = contactList + c;
				}
				
				if(contactList.equals(""))
					ta.setText("No contacts yet!");
				else
					ta.setText(contactList);
				
			}
		});
        
        viewNames.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String contactList = contacts.size() + " contacts:\n";
				
				for(Contact c : contacts) {
					contactList = contactList + c.getName() + "\n";
				}
				
				if(contactList.equals(""))
					ta.setText("No contacts yet!");
				else
					ta.setText(contactList);
				
			}
		});
        
        randomSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int random = (int) (Math.random() * contacts.size());
				
				ta.setText(contacts.get(random).toString());
				
			}
		});
        
	}

}
