// src/main/java/com/example/emp_control_system/Controllers/ProfileController.java
package com.example.emp_control_system.Controllers;

import com.example.emp_control_system.Entities.Employee;
import com.example.emp_control_system.Service.DepartmentService;
import com.example.emp_control_system.Service.EmployeeService;
import com.example.emp_control_system.dto.EmployeeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public ProfileController(EmployeeService employeeService,
                             DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping
    public String showProfile(Model model,
                              @ModelAttribute("employeeForm") EmployeeForm form) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "profile";
    }
    /** Обработка создания сотрудника. */
    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute("employeeForm") EmployeeForm form,
                              BindingResult br) {

        if (br.hasErrors()) {
            return "profile";
        }

        Employee employee = new Employee();
        employee.setName(form.getName());
        employee.setSurname(form.getSurname());
        employee.setEmail(form.getEmail());
        employee.setSalary(form.getSalary() == null ? 0 : form.getSalary());

        // отдел выбираем по id, если найден
        Optional.ofNullable(form.getDepartmentId())
                .flatMap(id -> departmentService.getById(id))
                .ifPresent(employee::setDepartment);

        employeeService.save(employee);
        return "redirect:/profile?success";
    }
}
