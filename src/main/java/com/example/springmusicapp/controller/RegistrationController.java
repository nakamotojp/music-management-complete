package com.example.springmusicapp.controller;

import com.example.springmusicapp.form.UserForm;
import com.example.springmusicapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(UserForm userForm) {
        userService.createUser(userForm);
        return "redirect:/login?register";
    }


}
