package com.github.wxz.service;


import com.github.wxz.dao.master.UserMapper;
import com.github.wxz.entity.User;
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

    public User getUserById(int id) {
        return this.userMapper.getUserById(id);
    }
}
