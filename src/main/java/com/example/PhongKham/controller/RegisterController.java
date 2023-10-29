package com.example.PhongKham.controller;


import com.example.PhongKham.model.Users;
import com.example.PhongKham.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    private LoginService loginService;

    @Autowired
    public RegisterController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/register")
    public String register(@ModelAttribute Users users, Model model) {
        model.addAttribute("users", new Users());
        return "home/register";
    }

    @PostMapping("/register")
    public String register(@Valid Users users, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            return "home/register";
        }
        // Kiem tra trung lap
        if (loginService.isUsernameExists(users.getUsername(), users.getEmail())) {
            model.addAttribute("error", "Tên người dùng hoặc email đã tồn tại . Vui lòng nhập lại ");
            return "home/register";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        // Thực hiện đăng ký
        loginService.register(users);
        return "redirect:/login";

    }
}
