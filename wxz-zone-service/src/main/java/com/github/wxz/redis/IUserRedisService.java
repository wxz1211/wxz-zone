package com.github.wxz.redis;

import com.github.wxz.domain.UserDo;

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
    void saveUsers(List<UserDo> users);

    /**
     * saveUser
     *
     * @param userDo
     */
    void saveUser(UserDo userDo);

    /**
     * findAll
     *
     * @return
     */
    List<UserDo> findAll();

    /**
     * findById
     * @param id
     * @return
     */
    UserDo findById(String id);

    void deleteById(String id);
}
