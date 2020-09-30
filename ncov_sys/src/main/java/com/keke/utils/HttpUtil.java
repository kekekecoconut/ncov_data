package com.keke.utils;

import com.keke.domain.HttpPojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HttpUtil {

    /**
     * http请求
     * @param url
     * @param paramObj
     * @param httpPojo
     * @return
     */
    public String httpSendGet(String url, Map paramObj, HttpPojo httpPojo){
        String result = "";
        String urlName = url + "?" + parseParam(paramObj);

        BufferedReader in=null;
        try {
            URL realURL = new URL(urlName);
            URLConnection conn = realURL.openConnection();
            //伪造ip访问
            String ip = randIP();
            System.out.println("目前伪造的ip："+ip);
            conn.setRequestProperty("X-Forwarded-For", ip);
            conn.setRequestProperty("HTTP_X_FORWARDED_FOR", ip);
            conn.setRequestProperty("HTTP_CLIENT_IP", ip);
            conn.setRequestProperty("REMOTE_ADDR", ip);
            conn.setRequestProperty("Host", httpPojo.getHttpHost());
            conn.setRequestProperty("accept", httpPojo.getHttpAccept());
            conn.setRequestProperty("connection", httpPojo.getHttpConnection());
            conn.setRequestProperty("user-agent", httpPojo.getHttpUserAgent());
            conn.setRequestProperty("Referer",httpPojo.getHttpReferer()); //伪造访问来源
            conn.setRequestProperty("Origin", httpPojo.getHttpOrigin()); //伪造访问域名
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String s : map.keySet()) {
                //System.out.println(s + "-->" + map.get(s));
            }
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in!=null){
                try {
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        return result;
    }


    /**
     * 解析map
     * @param paramObj
     * @return
     */
    public String parseParam(Map paramObj){
        String param="";
        if (paramObj!=null&&!paramObj.isEmpty()){
            for (Object key:paramObj.keySet()){
                String value = paramObj.get(key).toString();
                param+=(key+"="+value+"&");

            }
        }
        return param;
    }

    /**
     * 伪造ip地址
     * @return
     */
    public String randIP() {
        Random random = new Random(System.currentTimeMillis());
        return (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1)
                + "." + (random.nextInt(255) + 1) + "."
                + (random.nextInt(255) + 1);
    }
}
