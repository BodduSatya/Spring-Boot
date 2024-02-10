package org.satya.controller;

import org.modelmapper.ModelMapper;
import org.satya.dto.postgres.CreditCardDTO;
import org.satya.dto.mysql.CustomerDTO;
import org.satya.entity.mysql.Customer;
import org.satya.entity.postgres.CreditCard;
import org.satya.repository.mysql.CustomerRepository;
import org.satya.repository.postgres.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long customerID){
        return modelMapper.map(customerRepository.findById(customerID), CustomerDTO.class);
    }

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        return modelMapper.map(customerRepository.save(customer),CustomerDTO.class);
    }

    @GetMapping("/creditCard/{id}")
    public CreditCardDTO getCreditCardinfo(@PathVariable("id") Long creditCardID){
        return modelMapper.map(creditCardRepository.findById(creditCardID), CreditCardDTO.class);
    }

    @PostMapping("/creditCard")
    public CreditCardDTO saveCreditCardInfo(@RequestBody CreditCardDTO creditCardDTO){
        CreditCard creditCard = modelMapper.map(creditCardDTO,CreditCard.class);
        return modelMapper.map(creditCardRepository.save(creditCard),CreditCardDTO.class);
    }
}
