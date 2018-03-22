package com.dragon.common.service.abs;

import com.dragon.common.entity.BaseEntity;
import com.dragon.common.service.IBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 339939 on 2018/3/22.
 */
public abstract class BaseService<T extends BaseEntity> implements IBaseService<T> {

    public static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);
}
