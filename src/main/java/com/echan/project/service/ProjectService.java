package com.echan.project.service;

import com.echan.project.dao.ProjectDao;
import com.echan.tools.ResultTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    @Autowired private ProjectDao projectDao;

    public List<Map<String,Object>> findProjectForAll() {
        try {
            return projectDao.queryProjectForAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Map<String,Object> addProject(String projectName, String middlewareId) {
        Map<String,Object> result = new HashMap<>();
        try {
            String projectId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            int num = projectDao.insertProject(projectId,projectName,middlewareId);
            if( num > 0 ){
                ResultTools.build(0,"添加成功！",result);
            }else {
                ResultTools.build(-1,"添加失败！",result);
            }
        }catch (Exception e){
            ResultTools.build(-1,e.getMessage(),result);
        } finally {
            return result;
        }
    }

    public Map<String,Object> findProjectById(String projectId) {
        try {
            return projectDao.queryProjectById(projectId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Map<String,Object> editProjectById(String projectId, String projectName, String middlewareId) {
        Map<String,Object> result = new HashMap<>();
        try {
            int num = projectDao.updateProjectById(projectId,projectName,middlewareId);
            if( num > 0 ){
                ResultTools.build(0,"修改成功！",result);
            }else {
                ResultTools.build(-1,"修改失败！",result);
            }
        }catch (Exception e){
            ResultTools.build(-1,e.getMessage(),result);
        } finally {
            return result;
        }
    }

    public Map<String,Object> removeProject(String projectId) {
        Map<String,Object> result = new HashMap<>();
        try {
            if( projectDao.deleteProject(projectId) > 0 ){
                ResultTools.build(0,"删除成功！",result);
            }else {
                ResultTools.build(-1,"删除失败！",result);
            }
        }catch (Exception e){
            ResultTools.build(-1,e.getMessage(),result);
        } finally {
            return result;
        }
    }

    public List<Map<String,Object>> findProjectNames() {
        try {
            return projectDao.queryProjectNames();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
