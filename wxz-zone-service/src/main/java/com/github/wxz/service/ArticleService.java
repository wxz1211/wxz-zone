package com.github.wxz.service;

import com.github.wxz.common.util.BeanUtils;
import com.github.wxz.common.util.PaginationManage;
import com.github.wxz.dao.ArticleMapper;
import com.github.wxz.dao.UserMapper;
import com.github.wxz.domain.ArticleDO;
import com.github.wxz.entity.Article;
import com.github.wxz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -18:34
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

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
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PaginationManage<ArticleDO> getArticlesByPage(Integer pageNo, Integer pageSize) {

        List<Article> articleList = articleMapper.getArticlesByPage((pageNo - 1) * pageSize, pageSize);
        List<ArticleDO> articleDOList = new ArrayList<>();

        articleList.stream().forEach(article -> {
            User user = userMapper.getUserById(article.getUid());
            ArticleDO articleDO = new ArticleDO();
            BeanUtils.copyProperties(articleDO, article);

            articleDO.setuName((user == null || user.getName() == null) ? "" : user.getName());
            articleDOList.add(articleDO);
        });

        int totalCount = articleMapper.count();
        PaginationManage<ArticleDO> articlePaginationManage = new PaginationManage<>();
        articlePaginationManage.setDataList(articleDOList);
        articlePaginationManage.setPageInfo(pageNo, pageSize);
        articlePaginationManage.setTotalCount(totalCount);
        return articlePaginationManage;
    }

    /**
     * getArticlesByPage
     *
     * @param pageNo
     * @return
     */
    public PaginationManage<ArticleDO> getArticlesByPage(Integer pageNo) {
        if (pageNo == null || pageNo == 0) {
            pageNo = 1;
        }
        return getArticlesByPage(pageNo, PaginationManage.DEFAULT_SIZE_8);
    }
}
