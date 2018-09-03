package com.echan.tools;

import java.util.Map;

public class ResultTools {
    // 构建数据返回结构
    public static void build(int code, String msge, Map<String,Object> resultMap){
        resultMap.put("code",code);
        resultMap.put("msge",msge);
    }
}
