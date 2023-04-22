package com.craigmgordon.employeeservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class EmployeeController {

	@GetMapping(path = "/employees")
	@CrossOrigin("http://localhost:20000")
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee1 = new Employee("John Smith", "035661");
		Employee employee2 = new Employee("Jane Doe", "998877");
		employees.add(employee1);
		employees.add(employee2);
		return employees;
	}
}
