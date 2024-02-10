package org.satya.entity.mysql;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class Customer {
    @Id
    private Long customerId;
    private String customerName;
    private String address;

}
