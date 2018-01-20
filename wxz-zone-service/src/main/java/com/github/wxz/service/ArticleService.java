package com.github.wxz.service;

import com.alibaba.fastjson.JSONArray;
import com.github.wxz.common.crypt.AesCrypt;
import com.github.wxz.common.util.BeanUtils;
import com.github.wxz.common.util.CommonContent;
import com.github.wxz.common.util.PaginationManage;
import com.github.wxz.dao.ArticleCategoryMapper;
import com.github.wxz.dao.ArticleMapper;
import com.github.wxz.dao.ArticleTagMapper;
import com.github.wxz.dao.UserMapper;
import com.github.wxz.domain.ArticleDO;
import com.github.wxz.entity.Article;
import com.github.wxz.entity.ArticleCategory;
import com.github.wxz.entity.ArticleTag;
import com.github.wxz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    /**
     * addArticle
     *
     * @param article
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Article addArticle(Article article) {
        articleMapper.addArticle(article);
        String sid = AesCrypt.encode(CommonContent.SECRET, article.getId().toString());
        articleMapper.updateSidByArticleId(article.getId(), sid);
        return articleMapper.getArticleByArticleId(article.getId());
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
            ArticleCategory articleCategory =
                    articleCategoryMapper.getArticleCateGoryById(article.getCategory());
            articleDO.setCategory(articleCategory.getName());

            List<String> tagList = JSONArray.parseArray(article.getTag(), String.class);
            StringBuilder stringBuilder = new StringBuilder();
            tagList.stream().forEach(tag -> {
                ArticleTag articleTag = articleTagMapper.getArticleTagById(Integer.valueOf(tag));
                stringBuilder.append(articleTag.getName() + ",");
            });
            articleDO.setTag(stringBuilder.substring(0, stringBuilder.length() - 1));
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


    public List<Article> getChosenArticles() {
        return articleMapper.getChosenArticles();
    }
}
