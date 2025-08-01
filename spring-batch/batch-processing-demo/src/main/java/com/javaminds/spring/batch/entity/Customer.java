package com.javaminds.spring.batch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CUSTOMER_INFO")
@Data
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="GENDER")
    private String gender;

    @Column(name="CONTACT")
    private String contact;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="DOB")
    private String dob;


}
