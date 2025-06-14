package com.example.JavaShogi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/home")
    public String home() {
        return "home";  // src/main/resources/templates/home.html を返す（Thymeleafなどを使う場合）
    }
   

}
