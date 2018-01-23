package com.github.wxz.domain;

import java.util.Date;
import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/23 -14:16
 */
public class LeaveMsgDO {
    private Integer id;
    private Integer uid;
    private String uName;
    private String img;
    private Integer floor;
    private Integer parent;
    private String memo;
    private Date create;
    private Date update;
    private List<LeaveMsgScdDO> leaveMsgScdDOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public List<LeaveMsgScdDO> getLeaveMsgScdDOList() {
        return leaveMsgScdDOList;
    }

    public void setLeaveMsgScdDOList(List<LeaveMsgScdDO> leaveMsgScdDOList) {
        this.leaveMsgScdDOList = leaveMsgScdDOList;
    }
}
