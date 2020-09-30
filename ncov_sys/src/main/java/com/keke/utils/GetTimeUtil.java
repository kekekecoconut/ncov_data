package com.keke.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimeUtil {

    public String getCurrentDate(){
        Date date = new Date();//获取当前的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String str = df.format(date);
        return str;
    }

    public Integer getMonth(){
        Date date = new Date();//获取当前的日期
        return date.getMonth();
    }

    public Integer getDay(){
        Date date = new Date();
        return date.getDay();
    }

}
