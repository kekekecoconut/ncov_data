package com.keke.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.keke.domain.*;
import com.keke.mapper.NewsMapper;
import com.keke.utils.HttpUtil;
import com.keke.utils.SemesterAnalyseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NewsService {

    @Autowired
    NewsMapper newsMapper;

    public void initNews(){
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
        String reg= "window.getTimelineService1 = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);

        String result="";
        if (totalMatcher.find()){
            result = totalMatcher.group(1);
            System.out.println(result);
            JSONArray array = JSONArray.parseArray(result);
            for(int i=0;i<array.size();i++){
                JSONObject jsonObject = JSONObject.parseObject(array.getString(i));
                News news = new News(jsonObject.getString("title"),jsonObject.getString("summary"),jsonObject.getString("infoSource"),jsonObject.getString("sourceUrl"));
                //获取当前的日期
                Date date = new Date();//获取当前的日期
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String str = df.format(date);//获取String类型的时间
                news.setDate(str);
                if(newsMapper.selectNewsByTitle(news.getTitle()).isEmpty()){
                    newsMapper.insertNews(news);
                }
                System.out.println(news);
            }

        }
    }

    public List<WordCloud> wordClouds(){
        int count = 0;
        List<ShortNews> list = this.showNews();
        List<WordCloud> keyword_list = new LinkedList<>();
        for (ShortNews s :
                list) {
            for (String str :
                    new SemesterAnalyseUtil().analyseSemester(s.getTitle())) {
                if(str.length()>1 && !str.equals("可能") && !str.equals("未来")&& !str.equals("目前") && !str.equals("考前") && !str.equals("宣布") && !str.equals("组织") && !str.equals("举行") && !str.equals("提醒") && !str.equals("月份") && !str.equals("病例") && !str.equals("期间") && !str.equals("报告") && !str.equals("小孩") && !str.equals("全球") && !str.equals("期间") && !str.equals("运抵")&& !str.equals("新增") && !str.equals("必须")&& !str.equals("累计") && !str.equals("合计") && !str.equals("女子") && !str.equals("男子") && !str.equals("超过") && !str.equals("追加") && !str.equals("要求") && !str.equals("求助") && !str.equals("出现") && !str.equals("加强") && !str.contains("因")) {
                 //   if(count>35) break;
                    WordCloud wordCloud = new WordCloud(new Random().nextInt(1000),str);
                    keyword_list.add(wordCloud);
                //    count++;
                }
              //  if(count>35) break;
            }
        }
        Set<WordCloud> wordCloudSet = new HashSet<>(keyword_list);
        List<WordCloud> fl = new LinkedList<>(wordCloudSet);
        return fl;
    }

    public List<ShortNews> showNews(){
        List<ShortNews> shortNewsList = new LinkedList<>();
        List<News> list = newsMapper.showNews();
        for (News news:list
             ) {
            ShortNews shortNews = new ShortNews(news.getTitle(),news.getDate(),news.getSourceUrl());
            shortNewsList.add(shortNews);
        }
        Collections.sort(shortNewsList, new Comparator<ShortNews>() {
            @Override
            public int compare(ShortNews o1, ShortNews o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        System.out.println("排序后的list集合为："+shortNewsList.toString());
        return shortNewsList;
    }
}
