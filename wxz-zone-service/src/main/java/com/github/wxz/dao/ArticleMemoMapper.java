package com.github.wxz.dao;

import com.github.wxz.entity.ArticleMemo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 19:42
 * @email: xianzhi@eastmoney.com
 */
@Mapper
public interface ArticleMemoMapper {
    /**
     * getFloorArticleMemo
     *
     * @param aid
     * @param parent
     * @return
     */
    List<ArticleMemo> getFloorArticleMemo(@Param("aid") Integer aid, @Param("parent") Integer parent);

    /**
     * addArticleMemo
     *
     * @param articleMemo
     * @return
     */
    Integer addArticleMemo(ArticleMemo articleMemo);

    /**
     * articleMemoCount
     * @param aid
     * @return
     */
    @Select("select count(1) from wxz_zone_article_memo where aid = #{aid}")
    Integer getArticleMemoTotalCount(@Param("aid") Integer aid);

    /**
     * getArticleMemoFloorCount
     * @param aid
     * @return
     */
    @Select("select count(1) from wxz_zone_article_memo where aid = #{aid} and parent = 0")
    Integer getArticleMemoFloorCount(@Param("aid") Integer aid);
}
