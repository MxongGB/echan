package com.echan.middleware.service;

import com.echan.middleware.dao.MiddlewareDao;
import com.echan.middleware.entity.Middleware;
import com.echan.tools.ResultTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MiddlewareService {
    @Autowired private MiddlewareDao middlewareDao;

    // 查询所有中间件
    public List<Map<String,Object>> findMiddlewareForAll() {
        try {
            return middlewareDao.queryMiddlewareForAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    // 添加中间件
    public Map<String,Object> addMiddleware(Middleware middleware) {
        Map<String,Object> result = new HashMap<>();
        try {
            middleware.setMiddlewareId(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
            int num = middlewareDao.insertMiddleware(middleware);
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
    // 根据ID修改中间件
    public Map<String,Object> editMiddlewareById(Middleware middleware) {
        Map<String,Object> result = new HashMap<>();
        try {
            int num = middlewareDao.updateMiddlewareById(middleware);
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
}
