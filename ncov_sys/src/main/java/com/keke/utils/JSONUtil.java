package com.keke.utils;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class JSONUtil extends LinkedHashMap<String, Object> {

    public static JSONUtil data(List<?> data){
        JSONUtil j = new JSONUtil();
        j.put("data",data);
        return j;
    }

    public static JSONUtil areaChart(List<?> data){
        JSONUtil j = new JSONUtil();
        j.put("name","美国");
        j.put("type","line");
        j.put("stack","确诊人数");
        Date date = new Date();
        int month = date.getMonth();
        GetTimeUtil g = new GetTimeUtil();

        return j;
    }

}
