package com.somsak.marauders.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            userService.registerUser(user);
            model.addAttribute("success", "Register successful!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "register";
    }
}
