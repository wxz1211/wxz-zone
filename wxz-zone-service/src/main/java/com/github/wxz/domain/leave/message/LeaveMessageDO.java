package com.github.wxz.domain.leave.message;

import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/23 -14:08
 */
public class LeaveMessageDO {
    private Integer leaveMessageCount;
    private List<LeaveMsgDO> leaveMsgDOList;

    public Integer getLeaveMessageCount() {
        return leaveMessageCount;
    }

    public void setLeaveMessageCount(Integer leaveMessageCount) {
        this.leaveMessageCount = leaveMessageCount;
    }

    public List<LeaveMsgDO> getLeaveMsgDOList() {
        return leaveMsgDOList;
    }

    public void setLeaveMsgDOList(List<LeaveMsgDO> leaveMsgDOList) {
        this.leaveMsgDOList = leaveMsgDOList;
    }
}


