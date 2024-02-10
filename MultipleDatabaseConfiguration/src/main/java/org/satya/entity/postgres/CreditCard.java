package org.satya.entity.postgres;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="credit_card")
public class CreditCard {
    @Id
    private Long id;
    private String name;
    private int expirationMonth;
    private int expirationYear;
}
