package com.github.wxz.service;

import com.github.wxz.dao.ArticleCategoryMapper;
import com.github.wxz.entity.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/20
 * @time: 16:03
 * @email: xianzhi@eastmoney.com
 */
@Service
public class ArticleCategoryService {

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    public ArticleCategory getArticleCateGoryById(Integer id) {
        return articleCategoryMapper.getArticleCateGoryById(id);
    }

    public List<ArticleCategory> getAllArticleCateGory() {
        return articleCategoryMapper.getAllArticleCateGory();
    }
}
