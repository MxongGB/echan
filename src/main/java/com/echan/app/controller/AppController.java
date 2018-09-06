package com.echan.app.controller;

import com.echan.app.entity.App;
import com.echan.app.service.AppService;
import com.echan.host.service.AppHostService;
import com.echan.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("app")
@Controller
public class AppController {
    @Autowired private AppService appService;
    @Autowired private AppHostService hostService;
    @Autowired private ProjectService projectService;

    @GetMapping("home")
    public String home(Model model){
        List<Map<String,Object>> projects = projectService.findProjectNames();
        model.addAttribute("projects",projects);
        return "app/app_list";
    }

    @PostMapping("search")
    public String search(@RequestParam(required = true) String projectId,Model model){
        List<Map<String,Object>> projects = projectService.findProjectNames();
        model.addAttribute("projects",projects);

        List<Map<String,Object>> apps = appService.findAppForAll(projectId);
        model.addAttribute("apps",apps);
        return "app/app_list";
    }

    @GetMapping("add")
    public String add(Model model){
        List<Map<String,Object>> appHosts = hostService.findAppHostIP();
        model.addAttribute("appHosts",appHosts);

        List<Map<String,Object>> projects = projectService.findProjectNames();
        model.addAttribute("projects",projects);
        return "app/app_add";
    }

    @ResponseBody
    @PostMapping("add")
    public Map<String,Object> add(
            String appName,String hostIp,String projectId, String deployPath, String scriptPath,
            String scriptStart, String scriptCheck,String scriptStop,String logFile){

        App app = new App("",appName,hostIp,projectId,deployPath,scriptPath,
                scriptStart,scriptCheck,scriptStop,logFile);
        return appService.addApp(app);
    }

    @GetMapping("edit")
    public String edit(@RequestParam(required = true) String appId, Model model){
        List<Map<String,Object>> appHosts = hostService.findAppHostIP();
        model.addAttribute("appHosts",appHosts);

        List<Map<String,Object>> projects = projectService.findProjectNames();
        model.addAttribute("projects",projects);

        Map<String,Object> app = appService.findAppById(appId);
        model.addAttribute("app",app);
        return "app/app_edit";
    }

    @ResponseBody
    @PostMapping("edit")
    public Map<String,Object> edit(
            String appId,String appName,String hostIp,String projectId, String deployPath,
            String scriptPath,String scriptStart, String scriptCheck,String scriptStop,String logFile){

        App app = new App(appId,appName,hostIp,projectId,deployPath,scriptPath,
                scriptStart,scriptCheck,scriptStop,logFile);
        return appService.editAppById(app);
    }

    @PostMapping("remove")
    @ResponseBody
    public Map<String,Object> remove(@RequestParam(required = true) String appId){
        return appService.removeApp(appId);
    }
}
