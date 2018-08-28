package com.echan.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("welcome")
@Controller
public class WelcomeController {

    @GetMapping("home")
    public String home(){
        return "sys/welcome";
    }
}
