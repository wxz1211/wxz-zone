package com.github.wxz.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xianzhi.wang
 * @date 2018/1/12 -15:07
 */
@Component
public class UserAuth {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAuth.class);
    private static final Object NULL = new Object();
    private static final String WXZ_ID_COOKIE_NAME = "wxz";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static boolean authenticate(HttpServletRequest request) {
        //return getCurrentUser(request) != null;
        return true;
    }

}
