package com.example.emp_control_system.Service;

import com.example.emp_control_system.Entities.Department;
import com.example.emp_control_system.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
    public Optional<Department> getById(int id) {
        return departmentRepository.findById(id);
    }
}
