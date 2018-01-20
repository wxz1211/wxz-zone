package com.github.wxz.service;

import com.github.wxz.dao.ArticleTagMapper;
import com.github.wxz.entity.ArticleTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/20
 * @time: 16:01
 * @email: xianzhi@eastmoney.com
 */
@Service
public class ArticleTagService {
    @Autowired
    private ArticleTagMapper articleTagMapper;

    public ArticleTag getArticleTagById(Integer id) {
        return articleTagMapper.getArticleTagById(id);
    }

    public List<ArticleTag> getAllArticleTag() {
        return articleTagMapper.getAllArticleTag();
    }
}
