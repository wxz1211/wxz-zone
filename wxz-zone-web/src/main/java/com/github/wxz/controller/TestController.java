package com.github.wxz.controller;

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
    @RequestMapping(value = "/test")
    @ResponseBody
    private String test() {

        return "{\"dsds\":\"11111\"}";
    }

    @RequestMapping(value = "/test1")
    private String test1(Model model) {
        model.addAttribute("name", "world");
        return "test";
    }
}
