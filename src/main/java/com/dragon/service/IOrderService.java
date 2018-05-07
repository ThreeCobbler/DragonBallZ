package com.dragon.service;

import com.dragon.dao.entity.OrderEO;

/**
 * @author  339939 on 2018/5/3.
 */
public interface IOrderService {

    /**
     * 创建订单
     * @param orderAmount
     * @return
     */
    OrderEO createOrder(Double orderAmount);

    /**
     * 根据订单号查询订单
     * @param orderNo
     * @return
     */
    OrderEO selectByOrderNo(String orderNo);

    /**
     * 修改
     * @param orderEO
     */
    void update(OrderEO orderEO);
}
