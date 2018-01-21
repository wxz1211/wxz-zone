package com.github.wxz.dao;

import com.github.wxz.entity.ArticleAccessLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 16:49
 * @email: xianzhi@eastmoney.com
 */
@Mapper
public interface ArticleAccessLogMapper {

    List<ArticleAccessLog> getArticleAccessLogByUid(@Param("uid") Integer uid);

    List<ArticleAccessLog> getArticleAccessLogByAid(@Param("aid") Integer aid);

    @Select("select count(1) from wxz_zone_article_access_log where aid = #{aid}")
    int getCountByAid(@Param("aid") Integer aid);

    int addArticleAccessLog(ArticleAccessLog articleAccessLog);
}
