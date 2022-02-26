package com.satya.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.satya.demo.modal.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>{

	List<Employee> findByName(String name);
	List<Employee> findByIdGreaterThan(int id);
	
	@Query("from Employee where name = ?1 order by salary")
	List<Employee> findByNameSorted(String name);
	
}
