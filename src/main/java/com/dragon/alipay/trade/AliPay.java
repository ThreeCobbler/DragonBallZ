package com.dragon.alipay.trade;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.dragon.dao.entity.OrderEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 339939 on 2018/5/3.
 */
@RestController
@RequestMapping("alipay")
public class AliPay {

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

    @Autowired
    private AlipayTradeWapPayRequest alipayTradeWapPayRequest;

    @Autowired
    private AlipayTradePagePayRequest alipayTradePagePayRequest;

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayTradeRefundRequest alipayTradeRefundRequest;

    @RequestMapping("pay")
    public void doPost(@RequestBody OrderEO order, HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse) throws ServletException, IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",APP_ID, APP_PRIVATE_KEY , FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
        //在公共参数中设置回跳和通知地址
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+order.getOrderNo()+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+order.getOrderAmount()+"," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            //调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        //直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


    /**
     * 电脑网站支付
     */
    @RequestMapping("/pay/pc")
    @ResponseBody
    public Object pc(@RequestBody OrderEO order) throws Exception {
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",APP_ID, APP_PRIVATE_KEY , FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); //获得初始化的AlipayClient
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", order.getOrderNo());
        bizContent.put("total_amount", order.getOrderAmount());
        bizContent.put("subject", "Iphone6 16G");
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
        alipayTradePagePayRequest.setBizContent(bizContent.toString());
        return alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
    }

    /**
     * 退款
     * @param orderEO
     * @throws AlipayApiException
     */
    @RequestMapping("refund")
    public AlipayTradeRefundResponse refund(@RequestBody OrderEO orderEO) throws AlipayApiException {
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", orderEO.getOrderNo());
        bizContent.put("refund_amount", orderEO.getOrderAmount());
        bizContent.put("refund_currency", "CNY");
        bizContent.put("refund_reason", "正常退款");
        alipayTradeRefundRequest.setBizContent(bizContent.toString());
        AlipayTradeRefundResponse response = alipayClient.execute(alipayTradeRefundRequest);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }

    @RequestMapping("refund/query")
    public void refundQuery(@RequestBody OrderEO order) throws AlipayApiException {
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", order.getOrderNo());
        bizContent.put("trade_no", order.getOrderAmount());
        bizContent.put("refund_currency", "CNY");
        bizContent.put("refund_reason", "正常退款");
        request.setBizContent("{" +
                "\"trade_no\":\"20150320010101001\"," +
                "\"out_trade_no\":\"2014112611001004680073956707\"," +
                "\"out_request_no\":\"2014112611001004680073956707\"" +
                "  }");
        AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }






}
