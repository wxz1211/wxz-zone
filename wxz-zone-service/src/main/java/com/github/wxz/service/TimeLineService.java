package com.github.wxz.service;

import com.github.wxz.common.util.PaginationManage;
import com.github.wxz.dao.TimeLineMapper;
import com.github.wxz.entity.TimeLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xianzhi.wang
 * @date 2018/1/23 -18:34
 */
@Service
public class TimeLineService {

    @Autowired
    private TimeLineMapper timeLineMapper;

    public PaginationManage<TimeLine> getTimeLineByPage(Integer pageNo, Integer pageSize) {
        PaginationManage<TimeLine> timeLinePaginationManage = new PaginationManage<>();
        timeLinePaginationManage.setPageInfo(pageNo, pageSize);
        timeLinePaginationManage.setTotalCount(timeLineMapper.count());
        timeLinePaginationManage.setDataList(timeLineMapper.getTimeLineByPage((pageNo - 1) * pageSize, pageSize));
        return timeLinePaginationManage;

    }
}
