package com.dragon.common.utils;

import com.alibaba.fastjson.JSON;
import com.dragon.common.service.abs.BaseService;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created by 339939 on 2018/3/22.
 */
public class HttpClientRequest extends BaseService{

    public static String getClientPostRequest(String url, Map<String, Object> map) {
        HttpResponse httpResponse = null;
        InputStream content = null;
        String responseStr;
        HttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Accept", "application/json");
            //将参数转换成json格式
            String str = JSON.toJSONString(map);
            // 解决中文乱码问题
            StringEntity entity = new StringEntity(str, Charset.forName("utf-8"));
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            httpResponse = httpClient.execute(httpPost);
            content = httpResponse.getEntity().getContent();
            responseStr = StreamIOHelper.inputStreamToStr(content, "utf-8");
            return responseStr;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info(e.getMessage());
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.getConnectionManager().shutdown();
                }
                if (content != null) {
                    content.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.info(e.getMessage());
            }
        }
        return "";
    }


    public static String getClientGetRequest(String url,List<NameValuePair> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String str = "";
        HttpGet httpGet = null;
        try {
            if (!CollectionUtils.isEmpty(params)) {
                //转换为键值对
                str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
                //创建Get请求
                httpGet = new HttpGet(url+"?"+str);
            }else {
                httpGet = new HttpGet(url);
            }
            //执行Get请求，
            response = httpClient.execute(httpGet);
            //得到响应体
            HttpEntity entity = response.getEntity();
            String responseStr = StreamIOHelper.inputStreamToStr(entity.getContent(), "utf-8");
            return responseStr;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //消耗实体内容
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭相应 丢弃http连接
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
