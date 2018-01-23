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
     * 根据parent 和 aid ,type 获取memo
     *
     * @param aid
     * @param parent
     * @param type
     * @return
     */
    List<ArticleMemo> getFloorArticleMemo(@Param("aid") Integer aid, @Param("parent") Integer parent, @Param("type") Integer type);

    /**
     * addArticleMemo
     *
     * @param articleMemo
     * @return
     */
    Integer addArticleMemo(ArticleMemo articleMemo);

    /**
     * articleMemoCount
     *
     * @param aid
     * @param type
     * @return
     */
    @Select("select count(1) from wxz_zone_article_memo where aid = #{aid} and type =#{type}")
    Integer getArticleMemoTotalCount(@Param("aid") Integer aid, @Param("type") Integer type);

    /**
     * getArticleMemoFloorCount
     *
     * @param aid
     * @param type
     * @return
     */
    @Select("select count(1) from wxz_zone_article_memo where aid = #{aid} and type =#{type} and parent = 0")
    Integer getArticleMemoFloorCount(@Param("aid") Integer aid, @Param("type") Integer type);
}
