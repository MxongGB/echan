package com.echan.middleware.controller;

import com.echan.host.service.AppHostService;
import com.echan.middleware.entity.Middleware;
import com.echan.middleware.service.MiddlewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("middleware")
@Controller
public class MiddlewareController {
    @Autowired private MiddlewareService middlewareService;
    @Autowired private AppHostService appHostService;

    @GetMapping("home")
    public String home(Model model){
        List<Map<String,Object>> middlewares = middlewareService.findMiddlewareForAll();
        model.addAttribute("middlewares",middlewares);
        return "middleware/middleware_list";
    }

    @GetMapping("add")
    public String add(Model model){
        List<Map<String,Object>> appHosts = appHostService.findAppHostIP();
        model.addAttribute("appHosts",appHosts);
        return "middleware/middleware_add";
    }

    @ResponseBody
    @PostMapping("add")
    public Map<String,Object> add(String middleName,String middleHost,
                                  String scriptPath,String scriptStart,String scriptCheck,
                                  String scriptStop,String browserPath){
        Middleware middleware = new Middleware("",middleName,middleHost,scriptPath,
                scriptStart,scriptCheck,scriptStop,browserPath);
        return middlewareService.addMiddleware(middleware);
    }

    @GetMapping("edit")
    public String edit(@RequestParam(required = true) String middlewareId, Model model){
        List<Map<String,Object>> appHosts = appHostService.findAppHostIP();
        model.addAttribute("appHosts",appHosts);

        Map<String,Object> middleware = middlewareService.findMiddlewareById(middlewareId);
        model.addAttribute("middleware",middleware);
        return "middleware/middleware_edit";
    }

    @ResponseBody
    @PostMapping("edit")
    public Map<String,Object> edit(String middleId,String middleName,String middleHost,
                                   String scriptPath,String scriptStart,String scriptCheck,
                                   String scriptStop,String browserPath){
        Middleware middleware = new Middleware(middleId,middleName,middleHost,scriptPath,
                scriptStart,scriptCheck,scriptStop,browserPath);
        return middlewareService.editMiddlewareById(middleware);
    }

    @PostMapping("remove")
    @ResponseBody
    public Map<String,Object> remove(@RequestParam(required = true) String middlewareId){
        // 删除中间件
        return middlewareService.removeMiddleware(middlewareId);
    }
}
