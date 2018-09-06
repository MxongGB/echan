package com.echan.app.service;

import com.echan.app.dao.AppDao;
import com.echan.app.entity.App;
import com.echan.tools.ResultTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppService {
    @Autowired private AppDao appDao;

    public List<Map<String,Object>> findAppForAll(String projectId) {
        try {
            return appDao.queryAppForAll(projectId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Map<String,Object> addApp(App app) {
        Map<String,Object> result = new HashMap<>();
        try {
            app.setAppId(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
            int num = appDao.insertApp(app);
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

    public Map<String,Object> findAppById(String appId) {
        try {
            return appDao.queryAppById(appId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Map<String,Object> editAppById(App app) {
        Map<String,Object> result = new HashMap<>();
        try {
            int num = appDao.updateAppById(app);
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

    public Map<String,Object> removeApp(String appId) {
        Map<String,Object> result = new HashMap<>();
        try {
            if( appDao.deleteApp(appId) > 0 ){
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
