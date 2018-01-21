package com.github.wxz.service;

import com.github.wxz.dao.ArticleMemoMapper;
import com.github.wxz.entity.ArticleMemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 20:01
 * @email: xianzhi@eastmoney.com
 */
@Service
public class ArticleMemoService {

    @Autowired
    private ArticleMemoMapper articleMemoMapper;

    /**
     * getFloorArticleMemo
     *
     * @param aid
     * @param parent
     * @return
     */
    public List<ArticleMemo> getFloorArticleMemo(Integer aid, Integer parent) {
        return articleMemoMapper.getFloorArticleMemo(aid, parent);
    }

    /**
     * addArticleMemo
     *
     * @param articleMemo
     * @return
     */
    public Integer addArticleMemo(ArticleMemo articleMemo) {
        return articleMemoMapper.addArticleMemo(articleMemo);
    }
}
