package com.github.wxz.service;

import com.github.wxz.dao.TimeLineMapper;
import com.github.wxz.entity.TimeLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/23 -18:34
 */
@Service
public class TimeLineService {

    @Autowired
    private TimeLineMapper timeLineMapper;

    public List<TimeLine> getTimeLineByPage(Integer begin, Integer pageSize) {
        return timeLineMapper.getTimeLineByPage(begin, pageSize);
    }
}
