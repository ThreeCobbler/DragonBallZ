package com.dragon.service.impl;

import com.dragon.common.enums.OrderStatus;
import com.dragon.dao.entity.OrderEO;
import com.dragon.dao.mapper.OrderEOMapper;
import com.dragon.service.IOrderRedis;
import com.dragon.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author  339939 on 2018/5/3.
 */
@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderEOMapper orderEOMapper;

    @Autowired
    private IOrderRedis orderRedis;

    @Override
    @Transactional(rollbackFor = Exception.class)
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

    /**
     * 根据订单号查询订单
     * @param orderNo
     * @return
     */
    @Override
    public OrderEO selectByOrderNo(String orderNo) {
        OrderEO order = new OrderEO();
        order.setOrderNo(orderNo);
        return orderEOMapper.selectOne(order);
    }

    /**
     * 修改
     * @param orderEO
     */
    @Override
    public void update(OrderEO orderEO) {
        orderEOMapper.updateByPrimaryKey(orderEO);
    }
}
