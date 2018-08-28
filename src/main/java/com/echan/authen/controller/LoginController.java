package com.echan.authen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("authen")
@Controller
public class LoginController {

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("title","login page!");
        return "authen/login";
    }

    @GetMapping("login")
    public String login(){
        return "index";
    }
}
