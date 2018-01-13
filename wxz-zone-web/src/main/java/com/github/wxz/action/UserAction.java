package com.github.wxz.action;

import com.github.wxz.common.response.Response;
import com.github.wxz.service.HeadPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangxianzhi
 * @date: 2018/1/13
 * @time: 16:43
 * @email: xianzhi@eastmoney.com
 */
@RestController
@RequestMapping("user")
public class UserAction {

    @Autowired
    private HeadPrinter headPrinter;

    @RequestMapping("/logout")
    public Response logout() {
        headPrinter.logout();
        return Response.SUCCESS;
    }
}
