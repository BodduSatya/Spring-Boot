package org.satya.springbootcache.modal;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="DEPARTMENT")
public class Department {

    @Id
    private long id;
    private String name;
    private String description;
    private char status;
}
