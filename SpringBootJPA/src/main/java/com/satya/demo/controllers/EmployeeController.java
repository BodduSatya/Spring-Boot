package com.satya.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.satya.demo.dao.EmployeeRepo;
import com.satya.demo.modal.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee emp) {
		repo.save(emp);
		return "home.jsp";
	}
	
	@RequestMapping("/showEmployee")
	public ModelAndView showEmployee(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("showEmployee.jsp");
		Employee emp = repo.findById(id).orElse(new Employee());
		mv.addObject(emp);
		
		System.out.println("findByName***"+repo.findByName("Ram"));
		System.out.println("findByIdGreaterThan***"+repo.findByIdGreaterThan(1001));
		System.out.println("findByNameSorted***"+repo.findByNameSorted("Raj"));
		
		return mv;
	}
	
	@RequestMapping(path="/employees",produces="application/xml")
	@ResponseBody
	public List<Employee> getEmps() {
		  
		return (List<Employee>) repo.findAll();
		 
	}
	
	@RequestMapping("/employee/{eid}")
	@ResponseBody
	public Optional<Employee> getEmp(@PathVariable("eid") String eid) {
		  
			 return repo.findById(Integer.parseInt(eid));
			 
			 
		
	}
}
