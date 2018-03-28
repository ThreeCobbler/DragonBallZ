package com.dragon.service.impl;

import com.dragon.common.utils.DateUtil;
import com.dragon.dao.entity.UserEO;
import com.dragon.dao.mapper.UserEOMapper;
import com.dragon.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 339939 on 2018/3/22.
 */
@Service
public class UserServiceImpl implements IUserService {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private final static String SALT = "大吉大利";

    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'userInfo'";

    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String USER_CACHE_NAME = "user";

    @Autowired
    private UserEOMapper userEOMapper;

    @CacheEvict(value=USER_CACHE_NAME,key=CACHE_KEY)
    @Override
    public UserEO add(UserEO user) {
        user.setCreateTime(new Date());
        user.setLastUpdateTime(new Date());
        String password = DigestUtils.md5DigestAsHex((user.getUserPassword() + SALT).getBytes());
        user.setUserPassword(password);
        this.checkUser(null,user.getUserName());
        this.checkUser(user.getUserAccount(),null);
        userEOMapper.insert(user);
        return user;
    }

    @Cacheable(value=USER_CACHE_NAME,key="'userInfo_'+#id")
    @Override
    public UserEO findById(Long id) {
        UserEO userEO = new UserEO();
        userEO.setId(id);
        System.out.println("没有走缓存");
        return userEOMapper.selectByPrimaryKey(userEO);
    }

    @CachePut(value = USER_CACHE_NAME,key = "'userInfo_'+#user.getId()")
    @Override
    @Transactional
    public UserEO updateUser(UserEO user) {
        UserEO userEO = userEOMapper.selectByPrimaryKey(user);
        userEO.setUserPassword(user.getUserPassword());
        userEOMapper.updateByPrimaryKey(userEO);
        return userEO;

    }

    @CacheEvict(value = USER_CACHE_NAME,key = "'userInfo_'+#id")//这是清除缓存.
    @Override
    public void deleteById(Long id) {
        UserEO userEO = new UserEO();
        userEO.setId(id);
        userEOMapper.deleteByPrimaryKey(userEO);
    }

    @Override
    public boolean checkUser(String userAccount, String userName) {
        Example example = new Example(UserEO.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(userAccount)) {
            criteria.andEqualTo("userAccount",userAccount);
        }
        if (StringUtils.isNotBlank(userName)) {
            criteria.andEqualTo("userName",userName);
        }
        int count = userEOMapper.selectCountByExample(example);
        if (count > 0) {
            throw new RuntimeException("该账户已经注册");
        }
        return true;
    }

    @Override
    public List<UserEO> getUserList(int page, int size,String startTime,String endTime) throws ParseException {
        PageHelper.startPage(page,size);
        Example example = new Example(UserEO.class);
        example.setOrderByClause("create_time DESC");
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(startTime)) {
            criteria.andGreaterThanOrEqualTo("createTime",startTime);
        }
        if (StringUtils.isNotBlank(endTime)){
            criteria.andLessThanOrEqualTo("createTime", DateUtil.oneDateLastTime(sdf.parse(endTime)));
        }
        List<UserEO> userList = userEOMapper.selectByExample(example);
        return userList;
    }
}
