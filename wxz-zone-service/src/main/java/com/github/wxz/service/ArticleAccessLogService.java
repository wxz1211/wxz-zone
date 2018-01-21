package com.github.wxz.service;

import com.github.wxz.dao.ArticleAccessLogMapper;
import com.github.wxz.entity.ArticleAccessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 16:49
 * @email: xianzhi@eastmoney.com
 */
@Service
public class ArticleAccessLogService {

    @Autowired
    private ArticleAccessLogMapper articleAccessLogMapper;


    public List<ArticleAccessLog> getArticleAccessLogByUid(Integer uid) {
        return articleAccessLogMapper.getArticleAccessLogByUid(uid);
    }

    public List<ArticleAccessLog> getArticleAccessLogByAid(Integer aid) {
        return articleAccessLogMapper.getArticleAccessLogByAid(aid);

    }

    public int getCountByAid(Integer aid) {
        return articleAccessLogMapper.getCountByAid(aid);
    }

    @Transactional(rollbackFor = Exception.class)
    public int addArticleAccessLog(Integer uid, Integer aid) {
        ArticleAccessLog articleAccessLog = new ArticleAccessLog();
        articleAccessLog.setUid(uid);
        articleAccessLog.setAid(aid);
        return articleAccessLogMapper.addArticleAccessLog(articleAccessLog);
    }
}
