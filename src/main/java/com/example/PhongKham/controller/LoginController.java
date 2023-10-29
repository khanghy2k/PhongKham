package com.example.PhongKham.controller;
import com.example.PhongKham.model.Login;
import com.example.PhongKham.model.Users;
import com.example.PhongKham.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    private LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new Login());
        return "home/login";
    }

    @PostMapping("/login")
    public String login(@Valid Login login, BindingResult bindingResult, HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            return "home/login";
        }
        Users users = loginService.findByUsername(login.getUsername());
        if (users != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", login.getUsername());
            return "redirect:/home/home";
        } else {
            model.addAttribute("error", "Tài Khoản hoặc mật khẩu không đúng");
            return "home/login";
        }

    }

}
