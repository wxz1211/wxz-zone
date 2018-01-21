package com.github.wxz.entity;

import java.util.Date;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 19:38
 * @email: xianzhi@eastmoney.com
 */
public class ArticleMemo {
    private Integer id;
    private Integer uid;
    private Integer aid;
    private Integer floor;
    private Integer parent;
    private String memo;
    private Date create;
    private Date update;

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

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    @Override
    public String toString() {
        return "ArticleMemo{" +
                "id=" + id +
                ", uid=" + uid +
                ", aid=" + aid +
                ", floor=" + floor +
                ", parent=" + parent +
                ", memo='" + memo + '\'' +
                ", create=" + create +
                ", update=" + update +
                '}';
    }
}
