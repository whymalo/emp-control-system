package com.example.emp_control_system;

import com.example.emp_control_system.Entities.Department;
import com.example.emp_control_system.Entities.Employee;
import com.example.emp_control_system.Entities.Status;
import com.example.emp_control_system.Repository.DepartmentRepository;
import com.example.emp_control_system.Repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmpControlSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpControlSystemApplication.class, args);
	}
}
