package com.echan.project.controller;

import com.echan.middleware.service.MiddlewareService;
import com.echan.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("project")
@Controller
public class ProjectController {
    @Autowired private ProjectService projectService;
    @Autowired private MiddlewareService middlewareService;

    @GetMapping("home")
    public String home(Model model){
        List<Map<String,Object>> projects = projectService.findProjectForAll();
        model.addAttribute("projects",projects);
        return "project/project_list";
    }

    @GetMapping("add")
    public String add(Model model){
        List<Map<String,Object>> middlewares = middlewareService.findMiddlewareName();
        model.addAttribute("middlewares",middlewares);
        return "project/project_add";
    }

    @ResponseBody
    @PostMapping("add")
    public Map<String,Object> add(String projectName,String middlewareId){
        return projectService.addProject(projectName,middlewareId);
    }

    @GetMapping("edit")
    public String edit(@RequestParam(required = true) String projectId, Model model){
        List<Map<String,Object>> middlewares = middlewareService.findMiddlewareName();
        model.addAttribute("middlewares",middlewares);

        Map<String,Object> project = projectService.findProjectById(projectId);
        model.addAttribute("project",project);
        return "project/project_edit";
    }

    @ResponseBody
    @PostMapping("edit")
    public Map<String,Object> edit(String projectId,String projectName,String middlewareId){
        return projectService.editProjectById(projectId,projectName,middlewareId);
    }

    @PostMapping("remove")
    @ResponseBody
    public Map<String,Object> remove(@RequestParam(required = true) String projectId){
        return projectService.removeProject(projectId);
    }
}
