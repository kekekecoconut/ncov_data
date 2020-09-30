package com.keke.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.keke.domain.*;
import com.keke.mapper.CountryDataMapper;
import com.keke.utils.DateListUtil;
import com.keke.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CountryDataService {
    @Autowired
    private CountryDataMapper countryDataMapper;

    public List<CountryData> selectAllCountry(){
        List<CountryData> list = countryDataMapper.selectAllData();
        return list;
    }

    public List<Integer> currentVarity(){
        LinkedList<Integer> cur = new LinkedList<>();
        List<String> date = new DateListUtil().getDateList2();
        System.out.println(date.toString());
        for (String d :
                date) {
            CountryDayData c = countryDataMapper.selectDayCurrent(d);
            cur.add(Integer.valueOf(c.getConfirmed())-Integer.valueOf(c.getCured())-Integer.valueOf(c.getDead()));
        }
        return cur;
    }

    public List<Integer> currentNumber(){
        LinkedList<Integer> cur = new LinkedList<>();
        List<String> date = new DateListUtil().getDateList2();
        System.out.println(date.toString());
        for (String d :
                date) {
            CountryDayData c = countryDataMapper.selectDayCurrent(d);
            cur.add(Integer.valueOf(c.getConfirmed()));
        }
        return cur;
    }

    public List<CountryShortData> selectTop5Data(){
        LinkedList<CountryShortData> fl = new LinkedList<>();
        int count=0;
        for (CountryData c: countryDataMapper.selectAllData()
             ) {
            CountryShortData csd = new CountryShortData(c.getProvinceName(),Double.valueOf(c.getDeadRate()));
            fl.add(csd);
        }
        Collections.sort(fl, new Comparator<CountryShortData>() {
            @Override
            public int compare(CountryShortData o1, CountryShortData o2) {
                BigDecimal j = BigDecimal.valueOf(o1.getDeadrate()).subtract(BigDecimal.valueOf(o2.getDeadrate()));
                int i = j.compareTo(BigDecimal.ZERO);
                if (i < 0) {
                    return 1;
                } else if (i > 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("fl:"+fl);
        LinkedList<CountryShortData> l = new LinkedList<>();
        for (CountryShortData c:fl
             ) {
            if(count>=5) break;
            l.add(c);
            count++;
        }
        return l;
    }

    public List<CountryConfirmed> selectConfirmed(){
        List<CountryData> list = countryDataMapper.selectAllData();
        List<CountryConfirmed> finallist = new LinkedList<>();
        finallist.add(new CountryConfirmed("Turkmenistan",0));
        finallist.add(new CountryConfirmed("Dem. Rep. Korea",0));
        finallist.add(new CountryConfirmed("W. Sahara",0));
        for (CountryData d: list
             ) {
            String str1 = d.getCurrentConfirmedCount();
            switch(d.getCountryFullName()){
                case "Trinidad & Tobago":
                    finallist.add(new CountryConfirmed("Trinidad and Tobago",Integer.valueOf(str1)));
                    break;
                case "United States of America":
                    finallist.add(new CountryConfirmed("United States",Integer.valueOf(str1)));
                    break;
                case "The United Kingdom":
                    finallist.add(new CountryConfirmed("United Kingdom",Integer.valueOf(str1)));
                    break;
                case "Russian Federation":
                    finallist.add(new CountryConfirmed("Russia",Integer.valueOf(str1)));
                    break;
                case "Iran (Islamic Republic of)":
                    finallist.add(new CountryConfirmed("Iran",Integer.valueOf(str1)));
                    break;
                case "Bolivia (Plurinational State of)":
                    finallist.add(new CountryConfirmed("Bolivia",Integer.valueOf(str1)));
                    break;
                case "Uzbekstan":
                    finallist.add(new CountryConfirmed("Uzbekistan",Integer.valueOf(str1)));
                    break;
                case "The Republic of Zambia":
                    finallist.add(new CountryConfirmed("Zambia",Integer.valueOf(str1)));
                    break;
                case "Central African Republic":
                    finallist.add(new CountryConfirmed("Central African Rep.",Integer.valueOf(str1)));
                    break;
                case "South Sudan":
                    finallist.add(new CountryConfirmed("S. Sudan",Integer.valueOf(str1)));
                    break;
                case "Republic of Korea":
                    finallist.add(new CountryConfirmed("Korea",Integer.valueOf(str1)));
                    break;
                case "The Republic of Yemen":
                    finallist.add(new CountryConfirmed("Yemen",Integer.valueOf(str1)));
                    break;
                case "Cote d Ivoire":
                    finallist.add(new CountryConfirmed("Côte d'Ivoire",Integer.valueOf(str1)));
                    break;
                case "Syrian ArabRepublic":
                    finallist.add(new CountryConfirmed("Syria",Integer.valueOf(str1)));
                    break;
                case "North Macedonia":
                    finallist.add(new CountryConfirmed("Macedonia",Integer.valueOf(str1)));
                    break;
                case "Republic of Moldova":
                    finallist.add(new CountryConfirmed("Moldova",Integer.valueOf(str1)));
                    break;
                case "Czechia":
                    finallist.add(new CountryConfirmed("Czech Rep.",Integer.valueOf(str1)));
                    break;
                case "Dominican Republic":
                    finallist.add(new CountryConfirmed("Dominican Rep.",Integer.valueOf(str1)));
                    break;
                case "Bosnia and Herzegovina":
                    finallist.add(new CountryConfirmed("Bosnia and Herz.",Integer.valueOf(str1)));
                    break;
                case "Laos":
                    finallist.add(new CountryConfirmed("Lao PDR",Integer.valueOf(str1)));
                    break;
                case "Democratic Republic of the Congo":
                    finallist.add(new CountryConfirmed("Dem. Rep. Congo",Integer.valueOf(str1)));
                    break;
                case "The Republic of El Salvador":
                    finallist.add(new CountryConfirmed("El Salvador",Integer.valueOf(str1)));
                    break;
                case "The Republic of Fiji":
                    finallist.add(new CountryConfirmed("Fiji",Integer.valueOf(str1)));
                    break;
                case "Eq.Guinea":
                    finallist.add(new CountryConfirmed("Eq. Guinea",Integer.valueOf(str1)));
                    break;
                case "São Tomé and Príncipe":
                    finallist.add(new CountryConfirmed("São Tomé and Principe",Integer.valueOf(str1)));
                    break;
                case "The Republic of Djibouti":
                    finallist.add(new CountryConfirmed("Djibouti",Integer.valueOf(str1)));
                    break;
                case "occupied Palestinian territory":
                    finallist.add(new CountryConfirmed("Palestine",Integer.valueOf(str1)));
                    break;
                case "The Republic of Burundi":
                    finallist.add(new CountryConfirmed("Burundi",Integer.valueOf(str1)));
                    break;
                case "The Republic of Haiti":
                    finallist.add(new CountryConfirmed("Haiti",Integer.valueOf(str1)));
                    break;
                default:
                    finallist.add(new CountryConfirmed(d.getCountryFullName(),Integer.valueOf(str1)));
                    break;


            }
        }
        return finallist;
    }


    public void initCountryData(){
        String url="https://ncov.dxy.cn/ncovh5/view/pneumonia";
        //模拟请求
        HttpPojo httpPojo = new HttpPojo();
        httpPojo.setHttpHost("ncov.dxy.cn");
        httpPojo.setHttpAccept("*/*");
        httpPojo.setHttpConnection("keep-alive");
        httpPojo.setHttpUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        httpPojo.setHttpReferer("https://ncov.dxy.cn");
        httpPojo.setHttpOrigin("https://ncov.dxy.cn");
        Map paramObj = new HashMap();
        String htmlResult = new HttpUtil().httpSendGet(url, paramObj, httpPojo);
        String reg= "window.getListByCountryTypeService2true = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);

        String result="";
        if (totalMatcher.find()){
            result = totalMatcher.group(1);
            System.out.println(result);
            JSONArray array = JSONArray.parseArray(result);
            for(int i=0;i<array.size();i++){
                JSONObject jsonObject = JSONObject.parseObject(array.getString(i));
                CountryData countryData = new CountryData(jsonObject.getString("continents"), jsonObject.getString("provinceName"), jsonObject.getString("currentConfirmedCount"), jsonObject.getString("confirmedCount"), jsonObject.getString("suspectedCount"), jsonObject.getString("curedCount"), jsonObject.getString("deadCount"), jsonObject.getString("deadRate"), jsonObject.getString("countryFullName"));
                System.out.println(countryData);
                if(!countryDataMapper.selectDataByCountry(countryData.getProvinceName()).isEmpty()){
                    countryDataMapper.updateCountryData(countryData);
                }else{
                    countryDataMapper.insertCountryData(countryData);
                }
            }

        }
    }
}
