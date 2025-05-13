package com.example.emp_control_system.Repository;

import com.example.emp_control_system.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}