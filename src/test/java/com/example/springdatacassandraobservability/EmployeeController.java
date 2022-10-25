package com.example.springdatacassandraobservability;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping("/api/employees")
	EmployeeDto newEmployee(@RequestBody EmployeeDto newEmployee) {
		VerifiedEmployee inspectedEmployee = service.validate(newEmployee);
		return service.process(inspectedEmployee);
	}
}
