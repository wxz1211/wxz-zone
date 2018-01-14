package com.github.wxz.service;

import com.github.wxz.common.util.PageUtil;
import com.github.wxz.dao.ArticleMapper;
import com.github.wxz.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -18:34
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * addArticle
     *
     * @param article
     * @return
     */
    public Article addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    /**
     * @param articleId
     * @return
     */
    public Article getArticleByArticleId(Integer articleId) {
        return articleMapper.getArticleByArticleId(articleId);
    }

    /**
     * getArticlesByPage
     * @param begin
     * @param pageSize
     * @return
     */
    public PageUtil<Article> getArticlesByPage(Integer begin, Integer pageSize) {

        List<Article>  articleList = articleMapper.getArticlesByPage(begin, pageSize);

        return PageUtil.instance(articleList,begin,pageSize);
    }

    /**
     * getArticlesByPage
     * @param begin
     * @return
     */

    public PageUtil<Article> getArticlesByPage(Integer begin) {
        return getArticlesByPage(begin, PageUtil.DEFAULT_SIZE);
    }
}
