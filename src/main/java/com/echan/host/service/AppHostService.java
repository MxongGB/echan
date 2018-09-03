package com.echan.host.service;

import com.echan.host.dao.AppHostDao;
import com.echan.tools.ResultTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppHostService {
    private @Autowired AppHostDao appHostDao;

    // 查询所有主机
    public List<Map<String,Object>> findAppHostForAll() {
        try {
            return appHostDao.queryAppHostForAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    // 查询所有主机
    public List<Map<String,Object>> findAppHostByIP(String host_ip) {
        try {
            return appHostDao.queryAppHostByIP(host_ip);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    // 添加应用主机
    public Map<String,Object> addAppHost(String host_name, String host_ip, String user_name, String user_pass) {
        Map<String,Object> result = new HashMap<>();
        try {
            int num = appHostDao.insertAppHost(host_name,host_ip,user_name,user_pass);
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
    // 编辑主机信息
    public Map<String,Object> editAppHost(String host_name, String host_ip, String user_name, String user_pass) {
        Map<String,Object> result = new HashMap<>();
        try {
            int num = appHostDao.updateAppHost(host_name,host_ip,user_name,user_pass);
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
    // 根据IP查询主机信息
    public Map<String,Object> findAppHostForIP(String ip) {
        try {
            return appHostDao.queryAppHostForIP(ip);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    // 根据IP，删除主机信息
    public Map<String,Object> removeAppHost(String host_ip) {
        Map<String,Object> result = new HashMap<>();
        try {
            if( appHostDao.deleteAppHost(host_ip) > 0 ){
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
}
