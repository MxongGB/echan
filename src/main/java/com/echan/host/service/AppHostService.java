package com.echan.host.service;

import com.echan.host.dao.AppHostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // 添加应用主机
    public void addAppHost(String host_name, String host_ip, String user_name, String user_pass) {
        try {
            appHostDao.insertAppHost(host_name,host_ip,user_name,user_pass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
