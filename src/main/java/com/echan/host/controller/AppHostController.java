package com.echan.host.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.echan.host.service.AppHostService;
import com.sun.net.httpserver.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.Encoder;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String addHost(Model model){
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

    @GetMapping("edit")
    public String editHost(@RequestParam(required = true) String ip,Model model){
        Map<String,Object> appHost = appHostService.findAppHostForIP(ip);
        model.addAttribute("appHost",appHost);
        return "host/edit_app_host";
    }

    @PostMapping("edit")
    public String editHost(@RequestParam(required = true) String host_name,
                          @RequestParam(required = true) String host_ip,
                          @RequestParam(required = true) String user_name,
                          @RequestParam(required = true) String user_pass){
        appHostService.addAppHost(host_name,host_ip,user_name,user_pass);
        return "redirect:/app_host/home";
    }

}
