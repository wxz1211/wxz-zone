package com.github.wxz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xianzhi.wang
 * @date 2018/1/9 -18:18
 */
@RestController
public class TestController {
    @RequestMapping(value = "/test")
    private String test(){

        return "{\"dsds\":\"11111\"}";
    }
}
