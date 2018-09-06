package com.echan.app.dao;

import com.echan.app.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AppDao {
    @Autowired private JdbcTemplate template;

    public List<Map<String,Object>> queryAppForAll(String projectId) {
        String sql="select app_id,app_name,host_ip,project_id,deploy_path,script_path,script_start," +
                "script_check,script_stop,log_file from tf_b_app where project_id=?";
        return template.queryForList(sql,new Object[]{projectId});
    }

    public int insertApp(App app) {
        String sql="insert into tf_b_app(app_id, host_ip, project_id, app_name, deploy_path, script_path, script_start, script_check, script_stop, log_file) values (?,?,?,?,?,?,?,?,?,?)";
        return template.update(sql,new Object[]{
                app.getAppId(),app.getHostIp(),app.getProjectId(),app.getAppName(),
                app.getDeployPath(),app.getScriptPath(),app.getScriptStart(),
                app.getScriptCheck(),app.getScriptStop(),app.getLogFile()
        });
    }

    public Map<String,Object> queryAppById(String appId) {
        String sql="select * from tf_b_app where app_id=?";
        return template.queryForMap(sql,new Object[]{appId});
    }

    public int updateAppById(App app) {
        String sql="update tf_b_app set host_ip=?, project_id=?, app_name=?, deploy_path=?," +
                " script_path=?, script_start=?, script_check=?, script_stop=?, log_file=? where app_id=?";
        return template.update(sql,new Object[]{
                app.getHostIp(),app.getProjectId(),app.getAppName(),
                app.getDeployPath(),app.getScriptPath(),app.getScriptStart(),
                app.getScriptCheck(),app.getScriptStop(),app.getLogFile(),app.getAppId()
        });
    }

    public int deleteApp(String appId) {
        String sql="delete from tf_b_app where app_id=?";
        return template.update(sql,new Object[]{appId});
    }
}
