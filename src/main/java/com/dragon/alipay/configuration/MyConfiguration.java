package com.dragon.alipay.configuration;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by 339939 on 2018/5/4.
 */
@Configuration
@Order(0)
public class MyConfiguration {

    @Value("${APP_PRIVATE_KEY}")
    private String APP_PRIVATE_KEY;

    @Value("${ALIPAY_PUBLIC_KEY}")
    private String ALIPAY_PUBLIC_KEY;

    @Value("${SIGN_TYPE}")
    private String SIGN_TYPE;

    @Value("${AlipayConfig.CHARSET}")
    private String CHARSET;

    @Value("${AlipayConfig.FORMAT}")
    private String FORMAT;

    @Value("${APP_ID}")
    private String APP_ID;

    @Bean
    public AlipayTradePagePayRequest alipayTradePagePayRequest(){
        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl("http://localhost:8082/alipay/pay/return");
        alipayTradePagePayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");
        return alipayTradePagePayRequest;
    }

    @Bean
    public AlipayTradeWapPayRequest alipayTradeWapPayRequest(){
        AlipayTradeWapPayRequest alipayTradeWapPayRequest = new AlipayTradeWapPayRequest();
        alipayTradeWapPayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
        alipayTradeWapPayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");
        return alipayTradeWapPayRequest;
    }

    @Bean
    public AlipayClient getAlipayClient(){
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",APP_ID, APP_PRIVATE_KEY , FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        return alipayClient;
    }

    @Bean
    public AlipayTradeRefundRequest getAlipayTradeRefundRequest() {
        AlipayTradeRefundRequest alipayTradeRefundRequest = new AlipayTradeRefundRequest();
        return alipayTradeRefundRequest;
    }
}
