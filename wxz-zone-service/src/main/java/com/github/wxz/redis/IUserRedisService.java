package com.github.wxz.redis;

import com.github.wxz.domain.UserAuthDO;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/12 -13:16
 */
public interface IUserRedisService {

    /**
     *saveUsers
     * @param users
     */
    void saveUsers(List<UserAuthDO> users);

    /**
     * saveUser
     *
     * @param userAuthDO
     */
    void saveUser(UserAuthDO userAuthDO);

    /**
     * findAll
     *
     * @return
     */
    List<UserAuthDO> findAll();

    /**
     * findById
     * @param id
     * @return
     */
    UserAuthDO findById(String id);

    void deleteById(String id);
}
