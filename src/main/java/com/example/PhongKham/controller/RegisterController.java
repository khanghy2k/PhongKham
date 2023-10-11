package com.example.PhongKham.controller;


import com.example.PhongKham.model.Users;
import com.example.PhongKham.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
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

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String register(@ModelAttribute Users users, Model model) {
        model.addAttribute("users", new Users());
        return "home/register";
    }

    @PostMapping("/register")
    public String register(@Valid Users users, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return "home/register";
        }
        // Kiem tra trung lap
        if (loginService.isUsernameExists(users.getUsername(), users.getEmail())) {
            modelMap.addAttribute("error", "Tên người dùng hoặc email đã tồn tại . Vui lòng nhập lại ");
            return "home/register";
        }


        // Thực hiện đăng ký
        loginService.register(users);
        return "redirect:/login";

    }
}
