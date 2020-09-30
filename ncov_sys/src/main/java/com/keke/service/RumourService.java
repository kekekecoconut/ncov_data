package com.keke.service;

import com.keke.domain.HttpPojo;
import com.keke.utils.HttpUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RumourService {

    public void initRumour(){
        String url="https://ncov.dxy.cn/ncovh5/view/pneumonia_rumors";
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
        System.out.println(htmlResult);
    }

}
