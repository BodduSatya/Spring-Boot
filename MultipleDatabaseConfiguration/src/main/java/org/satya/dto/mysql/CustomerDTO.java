package org.satya.dto.mysql;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private String address;
}
