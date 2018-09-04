package com.echan.middleware.controller;

import com.echan.middleware.entity.Middleware;
import com.echan.middleware.service.MiddlewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("middleware")
@Controller
public class MiddlewareController {
    @Autowired private MiddlewareService middlewareService;

    @GetMapping("home")
    public String home(Model model){
        List<Map<String,Object>> middlewares = middlewareService.findMiddlewareForAll();
        model.addAttribute("middlewares",middlewares);
        return "middleware/middleware_list";
    }

    @GetMapping("add")
    public String add(Model model){
        return "middleware/middleware_add";
    }
    @PostMapping("add")
    public Map<String,Object> add(Middleware middleware){
        return middlewareService.addMiddleware(middleware);
    }
    @GetMapping("edit")
    public String edit(Model model){
        return "middleware/middleware_edit";
    }
    @PostMapping("edit")
    public Map<String,Object> edit(Middleware middleware){
        return middlewareService.editMiddlewareById(middleware);
    }
}
