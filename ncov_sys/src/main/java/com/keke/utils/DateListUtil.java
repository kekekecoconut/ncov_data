package com.keke.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DateListUtil {

    public List<String> getDateList(){
        GetTimeUtil g = new GetTimeUtil();
        List<String> list = new LinkedList<>();
        System.out.println(g.getDay());
        String str = g.getCurrentDate();
        char a = str.charAt(8);
        char b = str.charAt(9);
        String str2 = new String(String.valueOf(a));
        String str3 = new String(String.valueOf(b));
        str2 = str2.concat(str3);
   //     System.out.println(str2);
        if(Integer.valueOf(str2)>=15){
            for(int i=4;i<=7;i++){
               if(i<10){
                   list.add("2020-0"+i+"-15");
               }else{
                   list.add("2020-"+i+"-15");
               }
            }
        }else{
            for(int i=4;i<=7;i++){
                if(i<10){
                    list.add("2020-0"+i+"-15");
                }else{
                    list.add("2020-"+i+"-15");
                }
            }
        }
      //  list.add(g.getCurrentDate());
        list.add("2020-09-06");
        return list;
    }

    public List<String> getDateList2(){
        GetTimeUtil g = new GetTimeUtil();
        List<String> list = new LinkedList<>();
        System.out.println(g.getDay());
        String str = g.getCurrentDate();
        char a = str.charAt(8);
        char b = str.charAt(9);
        String str2 = new String(String.valueOf(a));
        String str3 = new String(String.valueOf(b));
        str2 = str2.concat(str3);
        //     System.out.println(str2);
        if(Integer.valueOf(str2)>=15){
            for(int i=3;i<=g.getMonth()+1;i++){
                if(i<10){
                    list.add("2020-0"+i+"-03");
                    list.add("2020-0"+i+"-15");
                }else{
                    list.add("2020-"+i+"-03");
                    list.add("2020-"+i+"-15");
                }
            }

        }else{
            for(int i=3;i<=g.getMonth();i++){
                if(i<10){
                    list.add("2020-0"+i+"-03");
                    list.add("2020-0"+i+"-15");
                }else{
                    list.add("2020-"+i+"-03");
                    list.add("2020-"+i+"-15");
                }
            }
        }
        list.add("2020-09-06");
      //  list.add(g.getCurrentDate());
        return list;
    }
}
