package com.echan.host.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AppHostDao {
    private @Autowired JdbcTemplate template;

    // 查询所有应用主机
    public List<Map<String,Object>> queryAppHostForAll() {
        return template.queryForList("select * from tf_b_host_app");
    }

    // 添加应用主机
    public void insertAppHost(String host_name, String host_ip, String user_name, String user_pass) {
        String sql = "insert into tf_b_host_app(host_ip, host_name, user_name, user_pass) values (?,?,?,?)";
        template.update(sql,new Object[]{host_ip,host_name,user_name,user_pass});
    }

    public Map<String,Object> queryAppHostForIP(String ip) {
        return template.queryForMap("select * from tf_b_host_app where host_ip=?",new Object[]{ip.trim()});
    }
}
