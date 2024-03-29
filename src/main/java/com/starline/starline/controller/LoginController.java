package com.starline.starline.controller;

import com.starline.starline.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.starline.starline.service.LoginService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    public LoginService loginService;
    private boolean block_user = true;

    @GetMapping("/register")
    public String register(){
        return "regiser.html";
    }
    @PostMapping("/registers")
    public String registers(Login info){
        var r = "";
        if(loginService.registers(info) == true)
        {
            r = "register";
            System.out.println("이미있어서 실패");
        }
        else{
            r = "";
            System.out.println("성공");
        }
        return "redirect:/"+r;
    }



    @PostMapping("/logins")
    public String logins(Login info){
        var r = "";
        if(loginService.login(info) == true)
        {
            block_user = false;
            r="main";
        }
        else{
            r="";
        }
        return "redirect:/";
    }
    @GetMapping("")
    public String main(Model model){

        model.addAttribute("block_user",block_user);

        return "main.html";
    }
}
