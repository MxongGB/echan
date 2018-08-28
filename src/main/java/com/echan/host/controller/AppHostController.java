package com.echan.host.controller;

import com.echan.host.service.AppHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequestMapping("app_host")
@Controller
public class AppHostController {
    private @Autowired AppHostService appHostService;

    @GetMapping("home")
    public String home(Model model){
        // 查询所有主机
        List<Map<String,Object>> appHostList = appHostService.findAppHostForAll();
        model.addAttribute("appHostList",appHostList);
        return "host/app_host";
    }

    @GetMapping("add")
    public String addHost(){
        return "host/add_app_host";
    }

    @PostMapping("add")
    public String addHost(@RequestParam(required = true) String host_name,
                          @RequestParam(required = true) String host_ip,
                          @RequestParam(required = true) String user_name,
                          @RequestParam(required = true) String user_pass){
        appHostService.addAppHost(host_name,host_ip,user_name,user_pass);
        return "redirect:/app_host/home";
    }
}
