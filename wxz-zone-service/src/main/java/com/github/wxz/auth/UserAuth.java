package com.github.wxz.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.wxz.common.crypt.AesCrypt;
import com.github.wxz.common.util.BeanUtils;
import com.github.wxz.common.util.UrlUtils;
import com.github.wxz.domain.UserAuthDO;
import com.github.wxz.entity.User;
import com.github.wxz.redis.StringRedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author xianzhi.wang
 * @date 2018/1/12 -15:07
 */
@Component
public class UserAuth {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAuth.class);
    private static final String WXZ_ID_COOKIE_NAME = "wxzId";

    @Autowired
    private StringRedisService stringRedisService;

    private  UserAuthDO toEncryptString(UserAuthDO userAuthDO) {
        if (StringUtils.isEmpty(userAuthDO.getWxzId())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(userAuthDO.getId());
            stringBuilder.append("_");
            stringBuilder.append(userAuthDO.getEmail());
            stringBuilder.append("_");
            stringBuilder.append(userAuthDO.getMobile());
            stringBuilder.append("_");
            stringBuilder.append(userAuthDO.getPass());

            if (StringUtils.isEmpty(userAuthDO.getSecret())) {
                userAuthDO.setSecret(AesCrypt.init128Key());
            }
            userAuthDO.setWxzId(AesCrypt.encode(userAuthDO.getSecret(), stringBuilder.toString()));
        }
        return userAuthDO;
    }

    private UserAuthDO toRedisKey(User user) {
        UserAuthDO userAuthDO = new UserAuthDO();
        BeanUtils.copyProperties(userAuthDO, user);
        return toEncryptString(userAuthDO);
    }

    public void invalidate(HttpServletRequest request) {
        String wxzId = getGidCookie(request);
        if (wxzId != null) {
            deleteWxzid(request);
            invalidate(wxzId);
        }
    }

    private void invalidate(String wxzId) {
        stringRedisService.delString(wxzId);
    }

    public boolean authenticate(HttpServletRequest request) {
        return getCurrentUser(request) != null;
    }

    public UserAuthDO getCurrentUser(HttpServletRequest request) {
        String wxzId = getGidCookie(request);
        UserAuthDO userAuthDO = authenticate0(wxzId);
        return userAuthDO;
    }

    private UserAuthDO authenticate0(String wxzId) {
        if (StringUtils.isEmpty(wxzId)) {
            return null;
        } else {
            String redisValue = stringRedisService.getString(wxzId);
            if (StringUtils.isEmpty(redisValue)) {
                return null;
            } else {
                UserAuthDO userAuthDO = JSON.parseObject(redisValue, UserAuthDO.class);
                return userAuthDO;
            }
        }
    }


    private String deleteWxzid(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {

            for (int i = 0; i < cookies.length; ++i) {
                Cookie cookie = cookies[i];
                if (WXZ_ID_COOKIE_NAME.equals(cookie.getName()) && cookie.getValue() != null) {
                    try {
                        String wxzId = UrlUtils.decode(cookie.getValue());
                        stringRedisService.delString(wxzId);
                        cookie.setMaxAge(0);
                        return wxzId;
                    } catch (Exception e) {
                        LOGGER.error("wxzId [" + cookie.getValue() + "] deserialize failed,", e);

                    }
                }
            }
        }
        return null;
    }


    public void writeWxzId(HttpServletResponse httpServletResponse, User user) {
        UserAuthDO userAuthDO = toRedisKey(user);
        stringRedisService.setString(userAuthDO.getWxzId(), JSON.toJSONString(userAuthDO), 3600 * 24 * 30 * 12);
        if (httpServletResponse != null) {
            Cookie cookie = new Cookie(WXZ_ID_COOKIE_NAME, UrlUtils.encode(userAuthDO.getWxzId()));
            cookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(60L));
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);
        }
    }

    private String getGidCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; ++i) {
                Cookie cookie = cookies[i];
                if (WXZ_ID_COOKIE_NAME.equals(cookie.getName()) && cookie.getValue() != null) {
                    try {
                        return UrlUtils.decode(cookie.getValue());
                    } catch (Exception e) {
                        LOGGER.error("wxzId [" + cookie.getValue() + "] deserialize failed,", e);
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
