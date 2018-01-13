package com.github.wxz.redis.impl;

import com.github.wxz.domain.UserAuthDO;
import com.github.wxz.framework.redis.service.IRedisService;
import com.github.wxz.redis.IUserRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/12 -13:18
 */
@Service
public class UserRedisServiceImpl extends IRedisService<UserAuthDO> implements IUserRedisService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRedisServiceImpl.class);

    private static final String USER_REDIS_KEY = "USER_REDIS_KEY";

    @Override
    protected String getHashRedisKey() {
        return USER_REDIS_KEY;
    }

    @Override
    public void saveUsers(List<UserAuthDO> users) {
        for (UserAuthDO user : users) {
            hashPut(String.valueOf(user.getId()), user, -1);
        }
    }

    @Override
    public void saveUser(UserAuthDO user) {
        hashPut(String.valueOf(user.getId()), user, -1);
    }

    @Override
    public List<UserAuthDO> findAll() {
        return hashGetAll();
    }

    @Override
    public UserAuthDO findById(String id) {
        return hashGetByKey(id);
    }

    @Override
    public void deleteById(String id) {
        hashRemoveByKey(id);
    }
}
