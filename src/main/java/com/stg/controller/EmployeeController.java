package com.stg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Employee;

@RestController
@RequestMapping(value="api")
public class EmployeeController {
	@PostMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> creatEmployee(@RequestBody Employee employee){
		System.out.println("Employee created");
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	@GetMapping(value="/readbyid/{alias}")
	public ResponseEntity<Employee> readEmployeeById(@PathVariable ("alias") int empId){
		Employee employeeTemp=null;
		if(empId==10) {
			employeeTemp=new Employee(10, "Ten");
			
		}
		if(empId==20) {
			employeeTemp=new Employee(20, "Twenty");
			
		}
		return new ResponseEntity<Employee>(employeeTemp,HttpStatus.FOUND);
	}
	@PutMapping(value="updete/{empName}")
	public Employee updateEmployeeByName(@RequestBody Employee empmoyee,String empName) {
		empmoyee.setEmpName(empName);
		return empmoyee;
	}

}
