package com.github.wxz.controller;

import com.github.wxz.common.response.Response;
import com.github.wxz.common.util.PaginationManage;
import com.github.wxz.domain.ArticleDO;
import com.github.wxz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xianzhi.wang
 * @date 2018/1/15 -15:01
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    public ArticleService articleService;

    @RequestMapping(value = "getArticleByPageNo")
    public Response article(@RequestParam("pageNo") Integer pageNo) {
        PaginationManage<ArticleDO> articlePaginationManage = articleService.getArticlesByPage(pageNo);
        return  Response.successResponse(articlePaginationManage);
    }
}
