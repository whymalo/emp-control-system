package com.example.emp_control_system.Controllers;

import com.example.emp_control_system.Service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
