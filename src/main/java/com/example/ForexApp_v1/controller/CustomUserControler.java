package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.model.CustomUser;
import com.example.ForexApp_v1.repositories.CustomUserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomUserControler {
    @GetMapping("/login")
    public String getLoginPage() {
        return "security/login";
    }

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("customUser", new CustomUser());
        return "security/register";
    }

    @PostMapping("/register")
    public String registerUser(CustomUser user) {
        CustomUserDAO dao = new CustomUserDAO();
        dao.createUser(user);
        return "index";
    }
}