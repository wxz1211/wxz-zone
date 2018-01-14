package com.github.wxz.controller;

import com.github.wxz.common.util.PageUtil;
import com.github.wxz.entity.Article;
import com.github.wxz.entity.User;
import com.github.wxz.service.ArticleService;
import com.github.wxz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -12:33
 */
@Controller
public class PageController {
    @Autowired
    public UserService userService;

    @Autowired
    public ArticleService articleService;

    @RequestMapping(value = "home")
    public String home(Model model) {
        User user = userService.getUserById(6);
        model.addAttribute("user", user);
        PageUtil<Article> articlePageUtil = articleService.getArticlesByPage(1);
        model.addAttribute("article", articlePageUtil);
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
