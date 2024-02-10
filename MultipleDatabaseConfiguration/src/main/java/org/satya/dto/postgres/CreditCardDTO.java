package org.satya.dto.postgres;

import lombok.Data;

@Data
public class CreditCardDTO {
    private Long id;
    private String name;
    private int expirationMonth;
    private int expirationYear;
}
