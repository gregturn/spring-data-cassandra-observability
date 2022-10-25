package com.example.springdatacassandraobservability;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    EmployeeDto process(VerifiedEmployee employeeDto) {
        return employeeDto;
    }

    public VerifiedEmployee validate(EmployeeDto newEmployee) {
        return null;
    }
}


