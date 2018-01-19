package com.github.wxz.controller;

import com.github.wxz.common.util.PaginationManage;
import com.github.wxz.domain.ArticleDO;
import com.github.wxz.entity.User;
import com.github.wxz.service.ArticleService;
import com.github.wxz.service.HeadPrinter;
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
public class IndexController {

    @Autowired
    public UserService userService;

    @Autowired
    public ArticleService articleService;

    @Autowired
    private HeadPrinter headPrinter;

    @RequestMapping(value = "home")
    public String home(Model model) {
        headPrinter.printHead(model);
        User user = userService.getUserById(6);
        model.addAttribute("user", user);
        PaginationManage<ArticleDO> articlePaginationManage = articleService.getArticlesByPage(1, PaginationManage.DEFAULT_SIZE_5);
        model.addAttribute("article", articlePaginationManage);
        return "home/home";
    }

    @RequestMapping(value = "article")
    public String article(Model model) {
        headPrinter.printHead(model);
        return "article/article";
    }

    @RequestMapping(value = "detail")
    public String detail(Model model) {
        headPrinter.printHead(model);
        return "detail/detail";
    }

    @RequestMapping(value = "about")
    public String about(Model model) {
        headPrinter.printHead(model);
        return "about/about";
    }

    @RequestMapping(value = "resource")
    public String resource(Model model) {
        headPrinter.printHead(model);
        return "resource/resource";
    }

    @RequestMapping(value = "timeline")
    public String timeline(Model model) {
        headPrinter.printHead(model);
        return "timeline/timeline";
    }

    @RequestMapping(value = "edit")
    public String edit(Model model) {
        headPrinter.printHead(model);
        return "edit/edit";
    }
}
