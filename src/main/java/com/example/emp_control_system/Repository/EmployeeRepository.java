package com.example.emp_control_system.Repository;

import com.example.emp_control_system.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String name, String surname, String email
    );
}