package com.example.emp_control_system.Controllers;

import com.example.emp_control_system.Entities.Employee;
import com.example.emp_control_system.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/employees/{id}")
    public String showEmployeeProfile(@PathVariable("id") int id, Model model) {
        Optional<Employee> employee = employeeService.getById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "employee-profile";
        } else {
            return "redirect:/employees";
        }
    }

}
