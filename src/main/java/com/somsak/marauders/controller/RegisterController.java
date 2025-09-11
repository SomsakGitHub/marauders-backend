package com.somsak.marauders.controller;

import com.somsak.marauders.dto.UserRegisterDTO;
import com.somsak.marauders.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userDto", new UserRegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDto") UserRegisterDTO dto, Model model) {
        try {
            userService.registerUser(dto);
            model.addAttribute("success", "Register successful!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "register";
    }
}
