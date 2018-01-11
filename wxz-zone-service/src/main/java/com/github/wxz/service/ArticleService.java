package com.github.wxz.service;

import com.github.wxz.dao.master.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -18:34
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
}
