package com.github.wxz.service;


import com.github.wxz.dao.UserMapper;
import com.github.wxz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -18:14
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    //@WriteDataSource
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    //@ReadDataSource
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    public User getUserByMobile(String mobile) {
        return userMapper.getUserByMobile(mobile);
    }

    //@WriteDataSource
    @Transactional(rollbackFor = Exception.class)
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }


    public Integer updatePic(Integer id, String imgPath) {
        return userMapper.updatePic(id, imgPath);
    }

}
