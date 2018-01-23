package com.github.wxz.dao;

import com.github.wxz.entity.TimeLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/23 -18:21
 */
@Mapper
public interface TimeLineMapper {

    List<TimeLine> getTimeLineByPage(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
}
