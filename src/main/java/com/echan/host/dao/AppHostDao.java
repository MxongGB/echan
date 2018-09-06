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
    // 根据IP地址查询
    public List<Map<String,Object>> queryAppHostByIP(String host_ip) {
        return template.queryForList("select * from tf_b_host_app where host_ip like '%"+host_ip+"%'");
    }
    // 添加应用主机
    public int insertAppHost(String host_name, String host_ip, String user_name, String user_pass) {
        String sql = "insert into tf_b_host_app(host_ip, host_name, user_name, user_pass) values (?,?,?,?)";
        return template.update(sql,new Object[]{host_ip,host_name,user_name,user_pass});
    }
    // 编辑主机信息
    public int updateAppHost(String host_name, String host_ip, String user_name, String user_pass) {
        String sql = "update tf_b_host_app set host_name=?,user_name=?,user_pass=? where host_ip=?";
        return template.update(sql,new Object[]{host_name,user_name,user_pass,host_ip});
    }
    // 根据IP查询主机
    public Map<String,Object> queryAppHostForIP(String ip) {
        return template.queryForMap("select * from tf_b_host_app where host_ip=?",new Object[]{ip.trim()});
    }
    // 根据IP删除主机
    public int deleteAppHost(String host_ip) {
        String sql = "delete from tf_b_host_app where host_ip=?";
        return template.update(sql,new Object[]{host_ip});
    }

    // 获取所有主机IP
    public List<Map<String,Object>> queryAppHostIP() {
        String sql="select host_ip from tf_b_host_app order by host_ip";
        return template.queryForList(sql);
    }
}
