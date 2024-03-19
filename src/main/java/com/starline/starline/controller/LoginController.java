package com.starline.starline.controller;

import com.starline.starline.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.starline.starline.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    public LoginService loginService;


    @GetMapping("/register")
    public String register(){
        return "regiser.html";
    }
    @PostMapping("/registers")
    public String registers(Login info){
        System.out.println(loginService.registers(info));
        return "redirect:/register";
    }


    @GetMapping("")
    public String login(){
        return "login.html";
    }
    @PostMapping("/logins")
    public String logins(Login info){
        var r = "";
        if(loginService.login(info) == true)
        {
            r="main";
        }
        else{
            r="";
        }
        return "redirect:/"+r;
    }
}
