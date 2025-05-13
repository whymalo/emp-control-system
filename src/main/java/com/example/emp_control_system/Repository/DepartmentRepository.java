package com.example.emp_control_system.Repository;

import com.example.emp_control_system.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}