package com.javaminds.spring.batch;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/*
Immutable object
* Class should be final , so other class can't extend.
* Fields should be final, even no setter, other developers may write one custom method to set the field value,
  so fields also final, means only one time assignment ( in our case through constructor ).
* Only getters, no setters.
* Values those are created while object creation through constructor is assigned once, no change, so immutability achieved.
* Thread-safe

 Immutable bean = object design style  - new Person("John")
 Factory pattern = object creation technique - Person.of("John")

 Immutable bean, Factory pattern Not the same, but often used together.

 Eg for Factory pattern

 public final class Person {
    private final String name;

    private Person(String name) {
        this.name = name;
    }

    public static Person of(String name) {
        return new Person(name); // Factory method
    }

    public String getName() {
        return name;
    }
}

Person p = Person.of("Alice");

* */

public final class Employee implements Serializable {

    private final String name;
    private final double salary;
    private final List<String> address;

    public Employee(String name, double salary, List<String> address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public List<String> getAddress() {
        return address;
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Test",50000, Arrays.asList("vskp","hyd"));

        System.out.println("getAddress = " + emp.getAddress());
        System.out.println("getSalary = " + emp.getSalary());
        System.out.println("getName = " + emp.getName());
    }

}
