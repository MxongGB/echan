package com.echan.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("app_service")
@Controller
public class AppServiceController {

    @GetMapping("home")
    public String home(){
        return "app/app_service";
    }
}
