package com.github.wxz.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.wxz.common.response.Response;
import com.github.wxz.entity.User;
import com.github.wxz.service.HeadPrinter;
import com.github.wxz.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: wangxianzhi
 * @date: 2018/1/13
 * @time: 18:29
 * @email: xianzhi@eastmoney.com
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private HeadPrinter headPrinter;

    @Autowired
    private UserService userService;


    @RequestMapping("/sign")
    public Response login(HttpServletResponse httpServletResponse, @RequestParam(value = "userDO",required = false) String userDO) {
        if (headPrinter.ifLogin()) {
            return Response.FAIL;
        }
        if (StringUtils.isAnyEmpty(userDO)) {
            return Response.FAIL;
        }


        User user = JSONObject.parseObject(userDO, User.class);
        userService.addUser(user);
        headPrinter.login(httpServletResponse, user);
        return Response.SUCCESS;
    }
}
