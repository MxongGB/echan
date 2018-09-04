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
        /*template.queryForList(sql, new RowMapper<Middleware>() {
            @Override
            public Middleware mapRow(ResultSet resultSet, int i) throws SQLException {
                Middleware middleware = new Middleware();
                middleware.setMiddlewareId(resultSet.getString("middleware_id"));
                middleware.setMiddlewareName(resultSet.getString("middleware_name"));
                middleware.setMiddlewareHost(resultSet.getString("middleware_host"));
                middleware.setScriptPath(resultSet.getString("script_path"));
                middleware.setScriptStart(resultSet.getString("script_start"));
                middleware.setScriptCheck(resultSet.getString("script_check"));
                middleware.setScriptStop(resultSet.getString("script_stop"));
                middleware.setBrowserPath(resultSet.getString("browser_path"));
                return middleware;
            }
        });*/
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
}
