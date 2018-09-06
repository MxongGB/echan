package com.echan.middleware.dao;

import com.echan.middleware.entity.Middleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class MiddlewareDao {
    @Autowired private JdbcTemplate template;

    // 查询所有中间件
    public List<Map<String, Object>> queryMiddlewareForAll() {
        String sql="select middleware_id,middleware_name,middleware_host,script_path,script_start,script_check,script_stop,browser_path from tf_b_middleware";
        return template.queryForList(sql);
    }
    // 添加中间件
    public int insertMiddleware(Middleware middleware) {
        String sql="insert into tf_b_middleware(middleware_id, middleware_name, middleware_host, " +
                "script_path,script_start,script_check,script_stop,browser_path) values (?,?,?,?,?,?,?,?)";
        return template.update(sql,new Object[]{
                middleware.getMiddlewareId(), middleware.getMiddlewareName(),
                middleware.getMiddlewareHost(), middleware.getScriptPath(),
                middleware.getScriptStart(),middleware.getScriptCheck(),
                middleware.getScriptStop(),middleware.getBrowserPath()});
    }
    // 根据ID修改中间件
    public int updateMiddlewareById(Middleware middleware) {
        String sql="update tf_b_middleware set middleware_name=?,middleware_host=?," +
                "script_path=?,script_start=?,script_check=?,script_stop=?," +
                "browser_path=? where middleware_id=?";
        return template.update(sql,new Object[]{
                middleware.getMiddlewareName(), middleware.getMiddlewareHost(),
                middleware.getScriptPath(), middleware.getScriptStart(),
                middleware.getScriptCheck(), middleware.getScriptStop(),
                middleware.getBrowserPath(),middleware.getMiddlewareId()});
    }

    public Map<String,Object> queryMiddlewareById(String middlewareId) {
        String sql="select middleware_id,middleware_name,middleware_host,script_path,script_start,script_check,script_stop,browser_path from tf_b_middleware where middleware_id=?";
        return template.queryForMap(sql,new Object[]{middlewareId});
    }

    public int deleteMiddleware(String middlewareId) {
        String sql="delete from tf_b_middleware where middleware_id=?";
        return template.update(sql,new Object[]{middlewareId});
    }

    public List<Map<String,Object>> queryMiddlewareName() {
        String sql="select middleware_id,middleware_name from tf_b_middleware";
        return template.queryForList(sql);
    }
}
