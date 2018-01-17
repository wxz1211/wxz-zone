package com.github.wxz.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.wxz.common.response.Response;
import com.github.wxz.common.util.BeanUtils;
import com.github.wxz.entity.User;
import com.github.wxz.request.UserLoginDO;
import com.github.wxz.request.UserSignDO;
import com.github.wxz.service.HeadPrinter;
import com.github.wxz.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private HeadPrinter headPrinter;

    @Autowired
    private UserService userService;


    @RequestMapping("/sign")
    public Response sign(HttpServletResponse httpServletResponse, @RequestParam(value = "userSign") String userSign) {
        if (headPrinter.ifLogin()) {
            return Response.FAIL;
        }
        if (StringUtils.isAnyEmpty(userSign)) {
            return Response.FAIL;
        }

        UserSignDO userSignDO = JSONObject.parseObject(userSign, UserSignDO.class);

        if (userService.getUserByMobile(userSignDO.getMobile()) != null || userService.getUserByName(userSignDO.getName()) != null) {
            return Response.FAIL;
        }
        User user = new User();
        BeanUtils.copyProperties(user, userSignDO);
        user.setPass(userSignDO.getPassword());
        //TODO　存入mysql数据库存在乱码问题
        userService.addUser(user);
        headPrinter.login(httpServletResponse, user);
        return Response.SUCCESS;
    }


    @RequestMapping("/login")
    public Response login(HttpServletResponse httpServletResponse, @RequestParam(value = "userLogin") String userLogin) {
        //是否已经登录
        if (headPrinter.ifLogin()) {
            return Response.FAIL;
        }
        if (StringUtils.isEmpty(userLogin)) {
            return Response.FAIL;
        }

        UserLoginDO userLoginDO = JSONObject.parseObject(userLogin, UserLoginDO.class);

        if (userLoginDO == null || StringUtils.isEmpty(userLoginDO.getMobile()) || StringUtils.isEmpty(userLoginDO.getPassword())) {
            return Response.FAIL;
        }

        User user = userService.getUserByMobile(userLoginDO.getMobile());

        if (user == null || !user.getPass().equals(userLoginDO.getPassword())) {
            return Response.FAIL;
        }

        headPrinter.login(httpServletResponse, user);
        LOGGER.info("user name {} login success ", user.getName());
        return Response.SUCCESS;
    }

    @RequestMapping("/nameRepeat")
    private Response nameRepeat(@RequestParam(value = "name") String name) {
        //是否已经登录
        if (headPrinter.ifLogin()) {
            return Response.FAIL;
        }
        if (StringUtils.isEmpty(name)) {
            return Response.FAIL;
        }

        User user = userService.getUserByName(name);
        if (user == null) {
            return Response.FAIL;
        }
        return Response.SUCCESS;
    }


    @RequestMapping("/mobileRepeat")
    private Response mobileRepeat(@RequestParam(value = "mobile") String mobile) {
        //是否已经登录
        if (headPrinter.ifLogin()) {
            return Response.FAIL;
        }
        if (StringUtils.isEmpty(mobile)) {
            return Response.FAIL;
        }

        User user = userService.getUserByMobile(mobile);
        if (user == null) {
            return Response.FAIL;
        }
        return Response.SUCCESS;
    }


}
