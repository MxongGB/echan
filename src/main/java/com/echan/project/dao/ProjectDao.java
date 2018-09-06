package com.echan.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProjectDao {
    @Autowired private JdbcTemplate template;

    public List<Map<String,Object>> queryProjectForAll() {
        String sql="select t.project_id,t.project_name,m.middleware_id,m.middleware_name from tf_b_project t,tf_b_middleware m where t.middleware_id=m.middleware_id ";
        return template.queryForList(sql);
    }

    public int insertProject(String projectId, String projectName, String middlewareId) {
        String sql="insert into tf_b_project(project_id, project_name, middleware_id) values (?,?,?)";
        return template.update(sql,new Object[]{projectId, projectName,middlewareId});
    }

    public Map<String,Object> queryProjectById(String projectId) {
        String sql="select project_id,project_name,middleware_id from tf_b_project where project_id=?";
        return template.queryForMap(sql,new Object[]{projectId});
    }

    public int updateProjectById(String projectId, String projectName, String middlewareId) {
        String sql="update tf_b_project set project_name=?,middleware_id=? where project_id=?";
        return template.update(sql,new Object[]{projectName, middlewareId,projectId});
    }

    public int deleteProject(String projectId) {
        String sql="delete from tf_b_project where project_id=?";
        return template.update(sql,new Object[]{projectId});
    }

    public List<Map<String,Object>> queryProjectNames() {
        String sql="select t.project_id,t.project_name from tf_b_project t ";
        return template.queryForList(sql);
    }
}
