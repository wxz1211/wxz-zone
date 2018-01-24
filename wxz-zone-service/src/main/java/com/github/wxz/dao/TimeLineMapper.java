package com.github.wxz.dao;

import com.github.wxz.entity.TimeLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/23 -18:21
 */
@Mapper
public interface TimeLineMapper {

    /**
     * getTimeLineByPage
     * @param begin
     * @param pageSize
     * @return
     */
    List<TimeLine> getTimeLineByPage(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);

    /**
     * count
     * @return
     */
    @Select("select count(1) from wxz_zone_time_line")
    Integer count();

}
