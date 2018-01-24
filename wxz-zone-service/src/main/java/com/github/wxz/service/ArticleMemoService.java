package com.github.wxz.service;

import com.github.wxz.common.util.BeanUtils;
import com.github.wxz.dao.ArticleMemoMapper;
import com.github.wxz.dao.UserMapper;
import com.github.wxz.domain.leave.message.LeaveMessageDO;
import com.github.wxz.domain.leave.message.LeaveMsgDO;
import com.github.wxz.domain.leave.message.LeaveMsgScdDO;
import com.github.wxz.entity.ArticleMemo;
import com.github.wxz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 20:01
 * @email: xianzhi@eastmoney.com
 */
@Service
public class ArticleMemoService {

    @Autowired
    private ArticleMemoMapper articleMemoMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * getFloorArticleMemo
     *
     * @param aid
     * @param parent
     * @return
     */
    public List<ArticleMemo> getFloorArticleMemo(Integer aid, Integer parent, Integer type) {
        return articleMemoMapper.getFloorArticleMemo(aid, parent, type);
    }

    /**
     * addArticleMemo
     *
     * @param articleMemo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer addArticleMemo(ArticleMemo articleMemo) {
        return articleMemoMapper.addArticleMemo(articleMemo);
    }

    public Integer getArticleMemoTotalCount(Integer aid, Integer type) {
        return articleMemoMapper.getArticleMemoTotalCount(aid, type);
    }

    public Integer getArticleMemoFloorCount(Integer aid, Integer type) {
        return articleMemoMapper.getArticleMemoFloorCount(aid, type);
    }

    public LeaveMessageDO getLeaveMessage() {
        LeaveMessageDO leaveMessageDO = new LeaveMessageDO();
        List<LeaveMsgDO> leaveMsgDOList = new ArrayList<>();
        List<ArticleMemo> articleMemoList = articleMemoMapper.getFloorArticleMemo(0, 0, 1);
        if (!CollectionUtils.isEmpty(articleMemoList)) {
            articleMemoList.stream().forEach(articleMemo -> {
                LeaveMsgDO leaveMsgDO = new LeaveMsgDO();
                BeanUtils.copyProperties(leaveMsgDO, articleMemo);
                User user1 = userMapper.getUserById(articleMemo.getUid());
                leaveMsgDO.setuName(user1.getName());
                leaveMsgDO.setImg(user1.getImg());
                List<ArticleMemo> articleMemos = articleMemoMapper.getFloorArticleMemo(
                        0, articleMemo.getId(), 1);
                if (!CollectionUtils.isEmpty(articleMemos)) {
                    List<LeaveMsgScdDO> leaveMsgScdDOList = new ArrayList<>();
                    articleMemos.stream().forEach(articleMemo1 -> {
                        LeaveMsgScdDO leaveMsgScdDO = new LeaveMsgScdDO();
                        BeanUtils.copyProperties(leaveMsgScdDO, articleMemo1);
                        User user2 = userMapper.getUserById(articleMemo1.getUid());
                        leaveMsgScdDO.setuName(user2.getName());
                        leaveMsgScdDO.setImg(user2.getImg());
                        leaveMsgScdDOList.add(leaveMsgScdDO);
                    });
                    leaveMsgDO.setLeaveMsgScdDOList(leaveMsgScdDOList);
                } else {
                    leaveMsgDO.setLeaveMsgScdDOList(Collections.EMPTY_LIST);
                }
                leaveMsgDOList.add(leaveMsgDO);
            });
        }
        leaveMessageDO.setLeaveMsgDOList(leaveMsgDOList);
        leaveMessageDO.setLeaveMessageCount(getArticleMemoFloorCount(0, 1));
        return leaveMessageDO;
    }
}
