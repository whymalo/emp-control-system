package com.example.emp_control_system.Controllers;

import com.example.emp_control_system.Entities.User;
import com.example.emp_control_system.Repository.UserRepository;
import com.example.emp_control_system.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public RegisterController(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder  = encoder;
    }


    @GetMapping("/register")
    public String showForm() {
        return "register";
    }


    @PostMapping("/register")
    public String doRegister(@ModelAttribute RegisterRequest req, Model model) {

        if (userRepo.findByUsername(req.username()).isPresent()) {
            model.addAttribute("error", true);
            return "redirect:/register?error";
        }

        User user = new User(
                true,
                "ROLE_USER",
                encoder.encode(req.password()),
                req.username()
        );
        userRepo.save(user);

        return "redirect:/login?success";
    }
}
