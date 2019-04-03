package com.dragon.message.weChat;

import com.alibaba.fastjson.JSONObject;
import com.dragon.common.utils.HttpClientRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljn
 * @date 2019/4/3.
 */
@Component
public class WeChatMessageManager {

    private static final Logger logger = LoggerFactory.getLogger(WeChatMessageManager.class);

    @Autowired
    private WeChatTokenRedis weChatTokenRedis;

    @Value("${getWeChatTokenUrl}")
    private String getTokenUrl;

    @Value("${sendWeChatMessageUrl}")
    private String sendMessageUrl;

    @Value("${corpid}")
    private String corpid;

    @Value("${corpsecret}")
    private String corpsecret;

    @Value("${agentid}")
    private String agentid;

    /**
     * 发送消息
     * @param content
     */
    public void sendMessage(String content) {
        String token = this.getToken();
        sendMessageUrl += "?access_token=" + token;
        SendMsgDTO text = new SendMsgDTO();
        text.setContent(content);
        Map<String, Object> map = new HashMap<>();
        map.put("touser", "@all");
        map.put("toparty", "@all");
        map.put("totag", "@all");
        map.put("msgtype", "text");
        map.put("agentid", agentid);
        map.put("text", text);
        map.put("safe", 0);
        String response = HttpClientRequest.getClientPostRequest(sendMessageUrl, map);
        if (StringUtils.isBlank(response)) {
            logger.info("发送微信信息发生异常:" + response);
            throw new RuntimeException("发送微信信息发生异常");
        }
        JSONObject jsonObject = JSONObject.parseObject(response);
        String errcode = jsonObject.getString("errcode");
        if (StringUtils.isBlank(errcode) || !errcode.equals("0")) {
            logger.info("发送微信信息发生异常:" + response);
            throw new RuntimeException("发送微信信息发生异常");
        }
    }

    /**
     * 获取token
     * @return
     */
    public String getToken() {
        String token = weChatTokenRedis.getToken();
        if (StringUtils.isNotBlank(token)) {
            return token;
        }
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("corpid", corpid));
        params.add(new BasicNameValuePair("corpsecret", corpsecret));
        String response = HttpClientRequest.getClientGetRequest(getTokenUrl, params);
        if (StringUtils.isBlank(response)) {
            logger.info("获取发送微信token发生异常:" + response);
            throw new RuntimeException("获取发送微信token发生异常");
        }
        JSONObject jsonResponse = JSONObject.parseObject(response);
        String accessToken = jsonResponse.getString("access_token");
        if (StringUtils.isBlank(accessToken)) {
            logger.info("获取发送微信token发生异常:" + response);
            throw new RuntimeException("获取发送微信token发生异常");
        }
        weChatTokenRedis.saveToken(accessToken);
        return accessToken;
    }
}
