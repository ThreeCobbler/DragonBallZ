package com.dragon.service.impl;

import com.dragon.common.redis.AbstractRedis;
import com.dragon.service.IOrderRedis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 339939 on 2018/5/3.
 */
@Component
public class OrderRedisImpl extends AbstractRedis implements IOrderRedis {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${ORDER_NO_KEY}")
    private String ORDER_NO_KEY;

    @Override
    protected StringRedisTemplate getTemplate() {
        return redisTemplate;
    }

    private SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

    @Override
    public String getOrderNo() {
        Long id = valueOps.increment(ORDER_NO_KEY, 1l);
        if (id == 1) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,23);
            cal.set(Calendar.MINUTE,59);
            cal.set(Calendar.SECOND,59);
            cal.set(Calendar.MILLISECOND,999);
            redisTemplate.expireAt(ORDER_NO_KEY,cal.getTime());
        }
        String str = StringUtils.leftPad(id.toString(), 7, "0");
        StringBuffer sb = new StringBuffer("DD");
        sb.append(sdf.format(new Date())).append(str);
        return sb.toString();
    }
}
