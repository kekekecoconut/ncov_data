package com.keke.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.keke.domain.CityNewData;
import com.keke.domain.HttpPojo;
import com.keke.domain.Increased;
import com.keke.domain.WorldData;
import com.keke.mapper.WorldDataMapper;
import com.keke.utils.DateListUtil;
import com.keke.utils.GetTimeUtil;
import com.keke.utils.HttpUtil;
import com.keke.utils.SemesterAnalyseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

@Service
public class AllDateDataService {

    @Autowired
    private WorldDataMapper worldDataMapper;

    public String analyseSemester(){
        SemesterAnalyseUtil s = new SemesterAnalyseUtil();
        return "123";
    }

    public Integer increasedDate(String country,String date){
        Integer i = Integer.parseInt(date.substring(8))-1;
        System.out.println("i:"+i);
        String datebefore = date.substring(0,8) + i;
        if(i<10){
            datebefore = date.substring(0,8) + "0"+i;
        }else{
            datebefore = date.substring(0,8) + i;
        }
        System.out.println(datebefore);
        System.out.println(worldDataMapper.selectConfirmed(datebefore, country));
        Integer increased = Integer.valueOf(worldDataMapper.selectConfirmed(date, country))-Integer.valueOf(worldDataMapper.selectConfirmed(datebefore, country));
        return increased;
    }

    public List<Increased> confirmedIncreased(){
        List<String> dateList = new DateListUtil().getDateList2();
        System.out.println(dateList);
        List<Increased> fl = new LinkedList<>();
        List<String> countryList = new LinkedList<>();
        countryList.add("美国");
        countryList.add("巴西");
        countryList.add("俄罗斯");
        countryList.add("英国");
      //  List<Integer> increasedList = new LinkedList<>();
        for (String country :
                countryList) {
            List<Integer> increasedList = new LinkedList<>();
            for (String date:
                    dateList) {
                //     Integer i =  Integer.valueOf(date.substring(8))-1;
                increasedList.add(this.increasedDate(country,date));
            }
            Increased increased = new Increased(country,dateList,increasedList);
            fl.add(increased);
        }
        return fl;
    }

    public List<Integer> confirmedData(String country){
        List<String> dateList = new DateListUtil().getDateList();
        System.out.println(dateList);
        List<Integer> confirmedDataList = new LinkedList<>();
        for (String d: dateList
             ) {
            String str = worldDataMapper.selectConfirmed(d,country);
            System.out.println(str);
            confirmedDataList.add(Integer.valueOf(str));
        }
        return confirmedDataList;
    }

    public void newService2(){
        String url="https://raw.githubusercontent.com/canghailan/Wuhan-2019-nCoV/master/Wuhan-2019-nCoV.json";
        //模拟请求
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("raw.githubusercontent.com");
        httpPojo.setHttpAccept("*/*");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        httpPojo.setHttpReferer("https://raw.githubusercontent.com");
        httpPojo.setHttpOrigin("https://raw.githubusercontent.com");
        Map paramObj = new HashMap();
        String htmlResult = new HttpUtil().httpSendGet(url, paramObj, httpPojo);
        JSONArray array = JSONArray.parseArray(htmlResult);
        for(int i=0;i<array.size();i++){
            JSONObject jsonObject = JSONObject.parseObject(array.getString(i));
            String str = new GetTimeUtil().getCurrentDate();
            System.out.println(str);
            String jsonDate = jsonObject.getString("date");
            if(str.equals(jsonDate)||str == jsonDate){
                WorldData worldData = new WorldData(jsonObject.getString("date"), jsonObject.getString("country"), jsonObject.getString("countryCode"), jsonObject.getString("province"), jsonObject.getString("city"), jsonObject.getString("provinceCode"), jsonObject.getString("cityCode"), jsonObject.getString("suspected"), jsonObject.getString("cured"), jsonObject.getString("dead"), jsonObject.getString("confirmed"));
                if(worldDataMapper.selectToday(str).isEmpty()){
                    worldDataMapper.insertToday(worldData);
                }
            }
        }
    }
}
