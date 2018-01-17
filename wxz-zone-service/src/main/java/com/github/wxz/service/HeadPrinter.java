package com.github.wxz.service;

import com.github.wxz.auth.UserAuth;
import com.github.wxz.domain.UserAuthDO;
import com.github.wxz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: wangxianzhi
 * @date: 2018/1/13
 * @time: 18:17
 * @email: xianzhi@eastmoney.com
 */
@Service
public class HeadPrinter {

    @Autowired
    private UserAuth userAuth;

    public UserAuthDO printHead(Model model) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserAuthDO userAuthDO = userAuth.getCurrentUser(httpServletRequest);
        if(userAuthDO!=null){
            model.addAttribute("currentUser",userAuthDO);
        }
        return userAuthDO;
    }


    public boolean ifLogin() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return userAuth.authenticate(httpServletRequest);
    }


    public void logout() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        userAuth.invalidate(httpServletRequest);
    }

    /**
     *
     * @param httpServletResponse
     * @param user
     */
    public void login(HttpServletResponse httpServletResponse,User user) {
        userAuth.writeWxzId(httpServletResponse, user);
    }
}
