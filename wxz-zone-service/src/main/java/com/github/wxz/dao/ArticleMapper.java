package com.github.wxz.dao;

import com.github.wxz.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -18:32
 */
@Mapper
public interface ArticleMapper {
    /**
     * addArticle
     *
     * @param article
     * @return
     */
    Article addArticle(Article article);

    /**
     * getArticleByArticleId
     * @param articleId
     * @return
     */
    Article getArticleByArticleId(@Param("articleId") Integer articleId);

    /**
     * getArticlesByPage
     * @param begin
     * @param pageSize
     * @return
     */
    List<Article> getArticlesByPage(@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);

    /**
     * count
     * @return
     */
    int count();
}
