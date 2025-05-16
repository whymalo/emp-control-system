package com.example.emp_control_system.Controllers;

import com.example.emp_control_system.Entities.Department;
import com.example.emp_control_system.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping("/departments")
    public String showDepartments(Model model){
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments";
    }

    @GetMapping("/departments/{id}")
    public String showDepartment(@PathVariable int id, Model model) {
        Department department = departmentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("department", department);
        return "department";
    }
}
