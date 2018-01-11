package com.github.wxz.service;


import com.github.wxz.dao.UserMapper;
import com.github.wxz.entity.User;
import com.github.wxz.framework.mybatis.annotation.ReadDataSource;
import com.github.wxz.framework.mybatis.annotation.WriteDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -18:14
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @WriteDataSource
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @ReadDataSource
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
