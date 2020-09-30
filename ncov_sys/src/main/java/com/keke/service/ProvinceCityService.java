package com.keke.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.keke.domain.*;
import com.keke.mapper.CityDataMapper;
import com.keke.mapper.ProvinceDataMapper;
import com.keke.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProvinceCityService {

    @Autowired
    private ProvinceDataMapper provinceDataMapper;
    @Autowired
    private CityDataMapper cityDataMapper;

    public List<CountryConfirmed> getProvinceConfirmed(){
        List<ProvinceData> list = provinceDataMapper.selectConfirmedDataProvince();
        List<CountryConfirmed> fl = new LinkedList<>();
        for (ProvinceData p :
                list) {
            CountryConfirmed c = new CountryConfirmed(p.getProvinceShortName(),Integer.valueOf(p.getCurrentConfirmedCount()));
            fl.add(c);
        }
        return fl;
    }

    public List<ProvinceData> selectAllProvince(){
        List<ProvinceData> list = provinceDataMapper.selectConfirmedDataProvince();
        return list;
    }

    public void initAreaData(){
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
        //   String htmlResult = httpSendGet(url, paramObj, httpPojo); //整个html页面
        String htmlResult = new HttpUtil().httpSendGet(url, paramObj, httpPojo);
        //正则获取数据
        //因为html的数据格式看着就像json格式，所以我们正则获取json
        String reg= "window.getAreaStat = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);
        String result="";
        if (totalMatcher.find()){
            result = totalMatcher.group(1);
            System.out.println(result);
            JSONArray array = JSONArray.parseArray(result);
            for(int i=0;i<array.size();i++){
                JSONObject jsonObject = JSONObject.parseObject(array.getString(i));
                ProvinceData provinceData = new ProvinceData(jsonObject.getString("provinceName"),jsonObject.getString("provinceShortName"),jsonObject.getString("currentConfirmedCount"),jsonObject.getString("confirmedCount"),jsonObject.getString("suspectedCount"),jsonObject.getString("curedCount"),jsonObject.getString("deadCount"),jsonObject.getString("comment"),jsonObject.getString("locationId"));
                if(!provinceDataMapper.selectDataByProvince(provinceData.getProvinceName()).isEmpty()){
                    provinceDataMapper.updateProvinceData(provinceData);
                }else{
                    provinceDataMapper.insertProvinceData(provinceData);
                }
                System.out.println(provinceData);
                String cities = jsonObject.getString("cities");
                List<CityData> cityData = JSONArray.parseArray(cities, CityData.class);
                //System.out.println(cityData);
                for(CityData cityData1:cityData){
                    CityNewData cityNewData = new CityNewData(cityData1.getCurrentConfirmedCount(),cityData1.getConfirmedCount(),cityData1.getCuredCount(),cityData1.getCityName(),cityData1.getLocationId(),cityData1.getDeadCount(),cityData1.getSuspectedCount(),jsonObject.getString("provinceName"));
                    if(!cityDataMapper.selectDataByCity(cityNewData.getCityName(),cityNewData.getProvinceName()).isEmpty()){
                        cityDataMapper.updateCityData(cityNewData);
                    }else{
                        cityDataMapper.insertCityData(cityNewData);
                    }
                    System.out.println(cityNewData);
                }
            }
        }
    }
}
