package com.echan.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("procedure")
@Controller
public class ProcedureController {

    @GetMapping("home")
    public String home(){
        return "db/procedure";
    }
}
