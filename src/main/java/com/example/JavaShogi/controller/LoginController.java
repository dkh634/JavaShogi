package com.example.JavaShogi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/home")
    public String home() {
        return "home";  
    }
    
    @GetMapping("/searchkifu")
    public String searchkifu() {
    	return "searchkifu";
    }
    
    @GetMapping("/game")
    public String game(Model model, Authentication authentication) {
    	// 認証情報を明示的にModelに追加
        String username = (authentication != null && authentication.isAuthenticated()) 
            ? authentication.getName() 
            : "ゲスト";
        model.addAttribute("username", username);
    	return "game";
    }
   

}
