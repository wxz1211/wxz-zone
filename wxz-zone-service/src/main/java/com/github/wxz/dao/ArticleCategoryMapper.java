package com.github.wxz.dao;

import com.github.wxz.entity.ArticleCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/20
 * @time: 15:49
 * @email: xianzhi@eastmoney.com
 */
@Mapper
public interface ArticleCategoryMapper {

    ArticleCategory getArticleCateGoryById(@Param("id") Integer id);

    List<ArticleCategory> getAllArticleCateGory();
}
