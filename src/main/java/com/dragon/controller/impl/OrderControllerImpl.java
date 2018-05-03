package com.dragon.controller.impl;

import com.dragon.common.dto.BaseResponse;
import com.dragon.dao.entity.OrderEO;
import com.dragon.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 339939 on 2018/5/3.
 */
@RestController
@RequestMapping("order")
public class OrderControllerImpl {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("createOrder")
    public BaseResponse createOrder(@RequestParam double orderAmount){
        BaseResponse response = new BaseResponse();
        try{
            OrderEO order = orderService.createOrder(orderAmount);
            response.setResult(order);
        }catch (RuntimeException e) {
            response.setErrorMessage(e.getMessage());
        }catch (Exception e){
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
