package com.dragon.service.impl;

import com.dragon.common.enums.OrderStatus;
import com.dragon.dao.entity.OrderEO;
import com.dragon.dao.mapper.OrderEOMapper;
import com.dragon.service.IOrderRedis;
import com.dragon.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 339939 on 2018/5/3.
 */
@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderEOMapper orderEOMapper;

    @Autowired
    private IOrderRedis orderRedis;

    @Override
    public OrderEO createOrder(Double orderAmount) {
        String orderNo = orderRedis.getOrderNo();
        OrderEO order = new OrderEO();
        order.setOrderNo(orderNo);
        order.setStatus(OrderStatus.WaitPay.getCode());
        order.setCreateTime(new Date());
        order.setLastUpdateTime(new Date());
        order.setOrderAmount(orderAmount);
        orderEOMapper.insert(order);
        return order;
    }
}
