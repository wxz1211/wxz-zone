package com.github.wxz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -12:33
 */
@Controller
public class PageController {
    @RequestMapping(value = "home")
    public String home() {
        return "home/home";
    }

    @RequestMapping(value = "article")
    public String article() {
        return "article/article";
    }

    @RequestMapping(value = "detail")
    public String detail() {
        return "detail/detail";
    }

    @RequestMapping(value = "about")
    public String about() {
        return "about/about";
    }

    @RequestMapping(value = "resource")
    public String resource() {
        return "resource/resource";
    }

    @RequestMapping(value = "timeline")
    public String timeline() {
        return "timeline/timeline";
    }
}
