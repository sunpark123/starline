package com.starline.starline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.starline.starline.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Autowired
    public LoginService loginService;


    @GetMapping("")
    public String test(){
        System.out.println(loginService.test());
        return "test.html";
    }
}
