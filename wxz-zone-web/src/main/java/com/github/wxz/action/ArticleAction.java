package com.github.wxz.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.wxz.common.response.Response;
import com.github.wxz.common.util.BeanUtils;
import com.github.wxz.domain.UserAuthDO;
import com.github.wxz.entity.Article;
import com.github.wxz.entity.ArticleMemo;
import com.github.wxz.request.UserArticleDO;
import com.github.wxz.request.UserMemoDO;
import com.github.wxz.service.ArticleMemoService;
import com.github.wxz.service.ArticleService;
import com.github.wxz.service.HeadPrinter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
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

    @Autowired
    private ArticleMemoService articleMemoService;


    @RequestMapping("/addArticle")
    public Response addArticle(Model model, @RequestParam("userArticle") String userArticle) {
        UserAuthDO userAuthDO = headPrinter.printHead(model);
        if (StringUtils.isEmpty(userArticle)) {
            return Response.FAIL;

        }
        UserArticleDO userArticleDO = JSONObject.parseObject(userArticle, UserArticleDO.class);
        if (userArticleDO == null
                || StringUtils.isEmpty(userArticleDO.getTitle())
                || StringUtils.isEmpty(userArticleDO.getSent())
                || StringUtils.isEmpty(userArticleDO.getContent())
                || CollectionUtils.isEmpty(userArticleDO.getTag())
                || StringUtils.isEmpty(userArticleDO.getCategory())
                ) {
            return Response.FAIL;
        }
        Article article = new Article();
        BeanUtils.copyProperties(article, userArticleDO);
        article.setCategory(Integer.valueOf(userArticleDO.getCategory()));
        article.setTag(JSON.toJSONString(userArticleDO.getTag()));
        article.setUid(userAuthDO.getId());
        articleService.addArticle(article);
        return Response.SUCCESS;
    }

    @RequestMapping("/addMemo")
    public Response addMemo(Model model, @RequestParam("userMemo") String userMemo) {
        UserAuthDO userAuthDO = headPrinter.printHead(model);
        if (StringUtils.isEmpty(userMemo)) {
            return Response.FAIL;
        }
        UserMemoDO userMemoDO = JSONObject.parseObject(userMemo, UserMemoDO.class);
        if (userMemoDO == null
                || StringUtils.isEmpty(userMemoDO.getMemo())
                || (userMemoDO.getFloor() == 0 && userMemoDO.getParent() == 0)
                ) {
            return Response.FAIL;
        }
        if(userMemoDO.getParent()==0){
            //articleMemoService.getFloorArticleMemo()
        }
        ArticleMemo articleMemo = new ArticleMemo();
        BeanUtils.copyProperties(articleMemo, userMemoDO);
        articleMemo.setUid(userAuthDO.getId());
        articleMemoService.addArticleMemo(articleMemo);
        return Response.SUCCESS;
    }
}
