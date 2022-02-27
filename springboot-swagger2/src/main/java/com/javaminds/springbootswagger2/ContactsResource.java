package com.javaminds.springbootswagger2;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class ContactsResource {
    ConcurrentHashMap<String,Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/")
    private ArrayList<Contact> getAllContacts(){
        return new ArrayList<>(contacts.values());
    }

    @GetMapping("/{id}")
    @ApiOperation( value="Finds contacts by id",
            notes = "Provide an id to  look  up  specific contact from the  address book",
            response = Contact.class )
    private Contact getContact(@ApiParam(value="ID value for the contact you need to retrieve",required = true)
                                @PathVariable String id){
        return contacts.get(id);
    }

    @PostMapping("/")

    private Contact addContact(@RequestBody Contact contact){
        return contacts.put(contact.getId(),contact);
    }


}
