package com.javaminds.socialapp.controller;

import com.javaminds.socialapp.exception.ResourceNotFoundException;
import com.javaminds.socialapp.model.Employee;
import com.javaminds.socialapp.repository.EmployeeRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //get employee
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployees(@PathVariable long id){
        Employee employee =  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id "+id ));
        return ResponseEntity.ok(employee);
    }

    //create employee
    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee ){
        return employeeRepository.save(employee);
    }

    //update employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee emp ){
        Employee employee =  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id "+id ));
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setEmailId(emp.getEmailId());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    //delete employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id ){
        Employee employee =  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id "+id ));
        employeeRepository.delete(employee);
        return ResponseEntity.ok(employee);
    }


}
