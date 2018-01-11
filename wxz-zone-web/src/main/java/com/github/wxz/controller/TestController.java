package com.github.wxz.controller;

import com.alibaba.fastjson.JSON;
import com.github.wxz.entity.User;
import com.github.wxz.service.UserService;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xianzhi.wang
 * @date 2018/1/9 -18:18
 */
@Controller
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    @ResponseBody
    private String test() {
        User user1 = userService.getUserByName("wangxianzhi");
        User user = userService.getUserById(20);
        LOGGER.info(JSON.toJSONString(user));
        LOGGER.info(JSON.toJSONString(user1));
        return "{\"dsds\":\"11111\"}";
    }

    @RequestMapping(value = "/test1")
    @ResponseBody
    private String test1(Model model) {
        User user1 = userService.getUserByName("wangxianzhi");
        User user = userService.getUserById(20);
        LOGGER.error(JSON.toJSONString(user));
        LOGGER.error(JSON.toJSONString(user1));
        model.addAttribute("name", "world");
        return "{\"dsds\":\"11111\"}";
    }
}
