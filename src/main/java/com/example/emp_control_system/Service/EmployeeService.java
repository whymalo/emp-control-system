package com.example.emp_control_system.Service;

import com.example.emp_control_system.Entities.Employee;
import com.example.emp_control_system.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(int id) {
        return employeeRepository.findById(id);
    }

}
