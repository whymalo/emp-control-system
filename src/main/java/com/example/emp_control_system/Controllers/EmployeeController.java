package com.example.emp_control_system.Controllers;

import com.example.emp_control_system.Service.EmployeeService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees"; // имя шаблона без .html
    }


}
