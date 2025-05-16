package com.example.emp_control_system.Repository;

import com.example.emp_control_system.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String name, String surname, String email
    );
}