package com.github.wxz.redis.impl;

import com.github.wxz.framework.redis.service.IRedisService;
import com.github.wxz.redis.StringRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author xianzhi.wang
 * @date 2018/1/12 -16:18
 */
@Service
public class StringRedisServiceImpl extends IRedisService<String> implements StringRedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringRedisServiceImpl.class);


    @Override
    public String getString(String key) {
        return get(key);
    }

    @Override
    public boolean existsString(String key) {
        return exists(key);
    }

    @Override
    public void setString(String key, String value) {
        set(key, value);
    }

    @Override
    public void setString(String key, String value, long expire) {
        set(key, value, expire);
    }

    @Override
    public void delString(String key) {
        del(key);
    }
}
