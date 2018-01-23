package com.github.wxz.service;

import com.alibaba.fastjson.JSONArray;
import com.github.wxz.common.crypt.AesCrypt;
import com.github.wxz.common.util.BeanUtils;
import com.github.wxz.common.util.CommonContent;
import com.github.wxz.common.util.PaginationManage;
import com.github.wxz.dao.*;
import com.github.wxz.domain.ArticleAccessLogDO;
import com.github.wxz.domain.ArticleDO;
import com.github.wxz.domain.ArticleMemoDO;
import com.github.wxz.domain.ArticleMemoSecondDO;
import com.github.wxz.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

    @Autowired
    private ArticleAccessLogMapper articleAccessLogMapper;

    @Autowired
    private ArticleMemoMapper articleMemoMapper;

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

        articleList.stream().forEach(article ->
                articleDOList.add(convertArticleToArticleDO(article)));

        int totalCount = articleMapper.count();
        PaginationManage<ArticleDO> articlePaginationManage = new PaginationManage<>();
        articlePaginationManage.setDataList(articleDOList);
        articlePaginationManage.setPageInfo(pageNo, pageSize);
        articlePaginationManage.setTotalCount(totalCount);
        return articlePaginationManage;
    }

    /**
     * convertArticleToArticleDO
     *
     * @param article
     * @return
     */
    public ArticleDO convertArticleToArticleDO(Article article) {
        User user = userMapper.getUserById(article.getUid());
        ArticleDO articleDO = new ArticleDO();
        BeanUtils.copyProperties(articleDO, article);

        //分类设置
        ArticleCategory articleCategory =
                articleCategoryMapper.getArticleCateGoryById(article.getCategory());
        articleDO.setCategory(articleCategory.getName());

        //标签设置
        List<String> tagList = JSONArray.parseArray(article.getTag(), String.class);

        String articleDOTag = tagList.stream().map(
                tag -> {
                    ArticleTag articleTag = articleTagMapper.getArticleTagById(Integer.valueOf(tag));
                    return articleTag.getName();
                })
                .collect(Collectors.joining(" "));
        articleDO.setTag(articleDOTag);

        int accessCount = articleAccessLogMapper.getCountByAid(article.getId());
        //访问次数
        articleDO.setAccessCount(accessCount);
        //访问实体类
        if (accessCount != 0) {
            List<ArticleAccessLog> articleAccessLogList = articleAccessLogMapper.getArticleAccessLogByAid(article.getId());
            List<ArticleAccessLogDO> articleAccessLogDOList =
                    articleAccessLogList.stream()
                            .filter(articleAccessLog -> articleAccessLog.getUid() == null
                                    || articleAccessLog.getUid() == 0)
                            .map(articleAccessLog -> {
                                ArticleAccessLogDO articleAccessLogDO = new ArticleAccessLogDO();
                                BeanUtils.copyProperties(articleAccessLogDO, articleAccessLog);
                                articleAccessLogDO.setName(userMapper.getUserById(articleAccessLog.getUid()).getName());
                                return articleAccessLogDO;
                            }).collect(Collectors.toList());
            articleDO.setArticleAccessLogList(articleAccessLogDOList);
        } else {
            articleDO.setArticleAccessLogList(Collections.EMPTY_LIST);
        }

        //评论数
        int memoCount = articleMemoMapper.getArticleMemoTotalCount(article.getId(),0);

        articleDO.setMemoCount(memoCount);
        //评论实体类
        if (memoCount != 0) {
            List<ArticleMemo> articleMemoList = articleMemoMapper.getFloorArticleMemo(article.getId(), 0,0);

            if (!CollectionUtils.isEmpty(articleMemoList)) {

                //TODO stream写法疑问???
                Supplier<List<ArticleMemoDO>> supplier = () -> new ArrayList<>();
                //lambada
                List<ArticleMemoDO> articleMemoDOList = new ArrayList<>();
                articleMemoList
                        .stream()
                        .forEach(articleMemo -> {
                            ArticleMemoDO articleMemoDO = new ArticleMemoDO();
                            BeanUtils.copyProperties(articleMemoDO, articleMemo);
                            User user1 = userMapper.getUserById(articleMemo.getUid());
                            articleMemoDO.setuName(user1.getName());
                            articleMemoDO.setImg(user1.getImg());
                            List<ArticleMemo> articleMemos = articleMemoMapper.getFloorArticleMemo(
                                    articleMemo.getAid(), articleMemo.getId(),0);

                            if (!CollectionUtils.isEmpty(articleMemos)) {
                                List<ArticleMemoSecondDO> articleMemoListSecond = new ArrayList<>();
                                articleMemos.stream().forEach(articleMemo1 -> {
                                    ArticleMemoSecondDO articleMemoSecondDO = new ArticleMemoSecondDO();
                                    BeanUtils.copyProperties(articleMemoSecondDO, articleMemo1);
                                    User user2 = userMapper.getUserById(articleMemo1.getUid());
                                    articleMemoSecondDO.setuName(user2.getName());
                                    articleMemoSecondDO.setImg(user2.getImg());
                                    articleMemoListSecond.add(articleMemoSecondDO);
                                });
                                articleMemoDO.setArticleMemoSecondDOList(articleMemoListSecond);
                            } else {
                                articleMemoDO.setArticleMemoSecondDOList(Collections.EMPTY_LIST);
                            }
                            articleMemoDOList.add(articleMemoDO);
                        });
                articleDO.setArticleMemoDOList(articleMemoDOList);
            } else {
                articleDO.setArticleMemoDOList(Collections.EMPTY_LIST);
            }
        } else {
            articleDO.setArticleMemoDOList(Collections.EMPTY_LIST);
        }

        articleDO.setuName((user == null || user.getName() == null) ? "" : user.getName());
        return articleDO;
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

    /**
     * 精选文章
     *
     * @return
     */
    public List<Article> getChosenArticles() {
        return articleMapper.getChosenArticles();
    }

    /**
     * 精选文章
     *
     * @return
     */
    public List<Article> getTopArticles() {
        return articleMapper.getTopArticles();
    }
}
