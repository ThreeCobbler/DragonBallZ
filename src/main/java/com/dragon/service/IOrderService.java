package com.dragon.service;

import com.dragon.dao.entity.OrderEO;

/**
 * Created by 339939 on 2018/5/3.
 */
public interface IOrderService {

    OrderEO createOrder(Double orderAmount);
}
