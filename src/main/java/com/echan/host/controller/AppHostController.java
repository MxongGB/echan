package com.echan.host.controller;

import com.echan.host.service.AppHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("search")
    public String search(@RequestParam(required = true) String host_ip,Model model){
        // 查询所有主机
        List<Map<String,Object>> appHostList = appHostService.findAppHostByIP(host_ip);
        model.addAttribute("appHostList",appHostList);
        model.addAttribute("seach_key",host_ip);
        return "host/app_host";
    }

    @GetMapping("add")
    public String addHost(){
        return "host/add_app_host";
    }

    @PostMapping("add")
    @ResponseBody
    public Map<String,Object> addHost(@RequestParam(required = true) String host_name,
                          @RequestParam(required = true) String host_ip,
                          @RequestParam(required = true) String user_name,
                          @RequestParam(required = true) String user_pass){
        // 添加主机
        return appHostService.addAppHost(host_name,host_ip,user_name,user_pass);
    }

    @GetMapping("edit")
    public String editHost(@RequestParam(required = true) String ip,Model model){
        Map<String,Object> appHost = appHostService.findAppHostForIP(ip);
        model.addAttribute("appHost",appHost);
        return "host/edit_app_host";
    }

    @PostMapping("edit")
    @ResponseBody
    public Map<String,Object> editHost(@RequestParam(required = true) String host_name,
                          @RequestParam(required = true) String host_ip,
                          @RequestParam(required = true) String user_name,
                          @RequestParam(required = true) String user_pass){
        // 修改主机信息
        return appHostService.editAppHost(host_name,host_ip,user_name,user_pass);
    }

    @PostMapping("remove")
    @ResponseBody
    public Map<String,Object> removeHost(@RequestParam(required = true) String host_ip){
        // 删除主机信息
        return appHostService.removeAppHost(host_ip);
    }
}
