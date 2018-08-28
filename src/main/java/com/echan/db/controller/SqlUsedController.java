package com.echan.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("sql_used")
@Controller
public class SqlUsedController {

    @GetMapping("home")
    public String home(){
        return "db/sql_used";
    }
}
