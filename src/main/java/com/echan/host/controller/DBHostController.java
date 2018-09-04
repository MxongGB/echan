package com.echan.host.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("db_host")
@Controller
public class DBHostController {

    @GetMapping("home")
    public String home(){
        return "db_host_list";
    }
}
