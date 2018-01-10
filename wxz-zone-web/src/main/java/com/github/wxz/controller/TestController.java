package com.github.wxz.controller;

import com.github.wxz.entity.User;
import com.github.wxz.service.UserService;
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
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    @ResponseBody
    private String test() {
        User user = userService.getUserById(20);
        return "{\"dsds\":\"11111\"}";
    }

    @RequestMapping(value = "/test1")
    private String test1(Model model) {
        model.addAttribute("name", "world");
        return "test";
    }
}
