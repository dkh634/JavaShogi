package com.example.JavaShogi.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
    public String login(Model model) {
		
        return "login";
    }
	
	 @PostMapping("/login")
	    public String processLogin(Model model, LoginForm loginForm) {
	        // ログイン処理（ここでは簡略化）
			model.addAttribute("loginUser", loginForm);
	        return "home"; // 成功時にリダイレクト
	    }
	
}

