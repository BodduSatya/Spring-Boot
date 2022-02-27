package com.javaminds.springbootswagger2;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookResource {

	private ConcurrentHashMap<String,Contact> contacts = new ConcurrentHashMap<>();
	
	@GetMapping("/")
	public ArrayList<Contact> getAllContacts(){
		return new ArrayList<>(contacts.values());
	}
	
	
	@GetMapping("/{id}")
	public Contact getContact(@PathVariable String id){
		return contacts.get(id);
	}
	
	
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact){
		return contacts.put(contact.getId(),contact);
	}
	
	
}
