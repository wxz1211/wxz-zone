package com.github.wxz.action;

import com.github.wxz.common.response.Response;
import com.github.wxz.domain.UserAuthDO;
import com.github.wxz.entity.Article;
import com.github.wxz.service.ArticleService;
import com.github.wxz.service.HeadPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xianzhi.wang
 * @date 2018/1/19 -18:12
 */
@RestController
@RequestMapping("article")
public class ArticleAction {

    @Autowired
    private HeadPrinter headPrinter;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("addArticle")
    public Response addArticle(Model model, @RequestParam("userArticle") String userArticle) {
        UserAuthDO userAuthDO = headPrinter.printHead(model);

        Article article = new Article();

        article.setUid(userAuthDO.getId());
        articleService.addArticle(article);
        return Response.SUCCESS;
    }

}
