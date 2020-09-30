package com.keke.controller;

import com.keke.domain.*;
import com.keke.service.*;
import com.keke.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class MainController {

    @Autowired
    private ProvinceCityService provinceCityService;
    @Autowired
    private CountryDataService countryDataService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private AllDateDataService allDateDataService;
    @Autowired
    private ChartsService chartsService;
    @Autowired
    private RumourService rumourService;
    @Autowired
    private CityDataService cityDataService;


    @RequestMapping("/main")
    public String mainPage(Model model){
        rumourService.initRumour();
        countryDataService.initCountryData();
        provinceCityService.initAreaData();
        newsService.initNews();
        allDateDataService.newService2();
        return "index";
    }

    @CrossOrigin
    @RequestMapping("/confirmedIncreased")
    @ResponseBody
    public List increased(){
        return allDateDataService.confirmedIncreased();
    }

    @CrossOrigin
    @RequestMapping("/worldClouds")
    @ResponseBody
    public List worldClouds(){
        return newsService.wordClouds();
    }

    @CrossOrigin
    @RequestMapping("/newsList")
    @ResponseBody
    public JSONUtil newsList(){
        List<ShortNews> list = newsService.showNews();
        return JSONUtil.data(list);
    }

    @CrossOrigin
    @RequestMapping("/allCountry")
    @ResponseBody
    public JSONUtil allCountry(){
        List<CountryData> list = countryDataService.selectAllCountry();
        return JSONUtil.data(list);
    }

    @CrossOrigin
    @RequestMapping("/allProvinces")
    @ResponseBody
    public JSONUtil allProvinces(){
        List<ProvinceData> list = provinceCityService.selectAllProvince();
        return JSONUtil.data(list);
    }


    @CrossOrigin
    @RequestMapping("/confirmedData")
    @ResponseBody
    public JSONUtil confirmedData(){
        List<Confirmed> list = chartsService.confirmedCountryData();
        List<ConfirmedRank> newList = new LinkedList<>();
        int count=1;
        for (Confirmed c: list
             ) {
            newList.add(new ConfirmedRank(c.getProvinceName(),c.getCurrentConfirmedCount(),c.getConfirmedCount(),c.getCuredCount(),count));
            count++;
        }
        return JSONUtil.data(newList);
    }

    @CrossOrigin
    @RequestMapping("/deadRate")
    @ResponseBody
    public List deadRate(){
        List<CountryShortData> newList = countryDataService.selectTop5Data();
        System.out.println(newList.toString());
        return newList;
    }

    @CrossOrigin
    @RequestMapping("/currentCountryConfirmed")
    @ResponseBody
    public List currentCountryConfirmed(){
        List<CountryConfirmed> newList = countryDataService.selectConfirmed();
        System.out.println(newList.toString());
        return newList;
    }

    @CrossOrigin
    @RequestMapping("/currentProvinceConfirmed")
    @ResponseBody
    public List currentProvinceConfirmed(){
        List<CountryConfirmed> newList = provinceCityService.getProvinceConfirmed();
        System.out.println(newList.toString());
        return newList;
    }

    @CrossOrigin
    @RequestMapping("/currentBeijingConfirmed")
    @ResponseBody
    public List currentBeijingConfirmed(){
        List<CountryConfirmed> newList = cityDataService.getBeijingConfirmed();
        System.out.println(newList.toString());
        return newList;
    }

    @CrossOrigin
    @RequestMapping("/currentXinjiangConfirmed")
    @ResponseBody
    public List currentXinjiangConfirmed(){
        List<CountryConfirmed> newList = cityDataService.getXinjiangConfirmed();
        System.out.println(newList.toString());
        return newList;
    }

    @CrossOrigin
    @RequestMapping("/currentVariety")
    @ResponseBody
    public List currentVariety(){
        List<Integer> c = countryDataService.currentVarity();
        System.out.println(c.toString());
        return c;
    }

    @CrossOrigin
    @RequestMapping("/currentNumber")
    @ResponseBody
    public List currentNumber(){
        List<Integer> c = countryDataService.currentNumber();
        System.out.println(c.toString());
        return c;
    }

    @CrossOrigin
    @RequestMapping("/allDateConfirmed")
    @ResponseBody
    public List allDateConfirmed(){
        List<AreaChart> finalList = new LinkedList<>();
        finalList.add(new AreaChart("美国",allDateDataService.confirmedData("美国")));
        finalList.add(new AreaChart("巴西",allDateDataService.confirmedData("巴西")));
        finalList.add(new AreaChart("俄罗斯",allDateDataService.confirmedData("俄罗斯")));
        finalList.add(new AreaChart("印度",allDateDataService.confirmedData("印度")));
        finalList.add(new AreaChart("英国",allDateDataService.confirmedData("英国")));
        System.out.println(finalList.toString());
        return finalList;
    }

}
