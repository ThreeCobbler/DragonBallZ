package com.dragon.alipay.trade;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.dragon.common.dto.BaseResponse;
import com.dragon.common.enums.OrderStatus;
import com.dragon.dao.entity.OrderEO;
import com.dragon.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author 339939 on 2018/5/3.
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
    private AlipayTradePagePayRequest alipayTradePagePayRequest;

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayTradeRefundRequest alipayTradeRefundRequest;

    @Autowired
    private IOrderService orderService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 付款
     * @param order
     * @param httpRequest
     * @param httpResponse
     * @throws ServletException
     * @throws IOException
     */
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
    public Object pc(@RequestBody OrderEO order) throws Exception {
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", order.getOrderNo());
        bizContent.put("total_amount", order.getOrderAmount());
        bizContent.put("subject", "Iphone6 16G");
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
        alipayTradePagePayRequest.setBizContent(bizContent.toString());
        return alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
    }

    /**
     * 付款同步回调
     * @param app_id
     * @param method
     * @param sign_type
     * @param sign
     * @param charset
     * @param timestamp
     * @param version
     * @param auth_app_id
     * @param out_trade_no
     * @param trade_no
     * @param total_amount
     * @param seller_id
     */
    @RequestMapping("/pay/return")
    public void payReturn(@RequestParam String app_id, @RequestParam String method, @RequestParam String sign_type,
                          @RequestParam String sign, @RequestParam String charset , @RequestParam String timestamp,
                          @RequestParam String version, @RequestParam String auth_app_id, @RequestParam String out_trade_no,
                          @RequestParam String trade_no, @RequestParam Double total_amount,@RequestParam String seller_id){
        OrderEO orderEO = orderService.selectByOrderNo(out_trade_no);
        orderEO.setTradeNo(trade_no);
        orderService.update(orderEO);
    }

    /**
     * 支付异步回调
     */
    @RequestMapping("pay/notify")
    public BaseResponse payNotify(@RequestParam Map<String,String> map) throws ParseException, AlipayApiException {
        BaseResponse response = new BaseResponse();
        boolean result = AlipaySignature.rsaCheckV1(map, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE);
        if (result) {
            OrderEO orderEO = orderService.selectByOrderNo(map.get("out_trade_no"));
            orderEO.setTradeNo(map.get("trade_no"));
            //支付接口以异步回调接口为主
            orderEO.setStatus(OrderStatus.AlreadyPay.getCode());
            orderEO.setLastUpdateTime(sdf.parse(map.get("notify_time")));
            orderService.update(orderEO);
            return response;
        }else{
            response.setErrorMessage("验证失败");
            return response;
        }

    }

    /**
     * 退款
     * @param orderNo
     * @throws AlipayApiException
     */
    @RequestMapping("refund")
    public AlipayTradeRefundResponse refund(@RequestParam String orderNo) throws AlipayApiException {
        OrderEO orderEO = orderService.selectByOrderNo(orderNo);
        if (orderEO == null) {
            throw new RuntimeException("订单不存在");
        }
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

    /**
     * 退款查询
     * @param orderNo
     * @throws AlipayApiException
     */
    @RequestMapping("refund/query")
    public AlipayTradeFastpayRefundQueryResponse refundQuery(@RequestParam String orderNo) throws AlipayApiException {
        OrderEO orderEO = orderService.selectByOrderNo(orderNo);
        if (orderEO == null) {
            throw new RuntimeException("订单不存在");
        }
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", orderEO.getOrderNo());
        bizContent.put("trade_no", orderEO.getTradeNo());
        bizContent.put("out_request_no", orderEO.getOrderNo());
        request.setBizContent(bizContent.toString());
        AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }

    /**
     * 查询交易订单状态
     * @param orderNo
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping("trade/query")
    public AlipayTradeQueryResponse tradeQuery(@RequestParam String orderNo) throws AlipayApiException {
        OrderEO orderEO = orderService.selectByOrderNo(orderNo);
        if (orderEO == null) {
            throw new RuntimeException("订单不存在");
        }
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject json = new JSONObject();
        json.put("out_trade_no",orderEO.getOrderNo());
        json.put("trade_no",orderEO.getTradeNo());
        request.setBizContent(json.toString());
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }

    /**
     * 关闭交易
     * 用于交易创建后，用户在一定时间内未进行支付，可调用该接口直接将未付款的交易进行关闭。
     * @param orderNo
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping("trade/close")
    public AlipayTradeCloseResponse tradeClose(@RequestParam String orderNo) throws AlipayApiException {
        OrderEO orderEO = orderService.selectByOrderNo(orderNo);
        if (orderEO == null) {
            throw new RuntimeException("订单不存在");
        }
        JSONObject json = new JSONObject();
        json.put("out_trade_no",orderEO.getOrderNo());
        json.put("operator_id","爱上层楼");
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizContent(json.toString());
        AlipayTradeCloseResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }

    /**
     * 查询对账单下载地址
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping("download/url/query")
    public AlipayDataDataserviceBillDownloadurlQueryResponse downloadUrlQuery() throws AlipayApiException {
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        JSONObject json = new JSONObject();
        json.put("bill_type","signcustomer");
        json.put("bill_date",format.format(new Date()));
        request.setBizContent(json.toString());
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response;
    }





}
