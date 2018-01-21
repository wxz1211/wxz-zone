package com.github.wxz.domain;

import java.util.Date;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 17:23
 * @email: xianzhi@eastmoney.com
 */
public class ArticleAccessLogDO {
    private Integer id;
    private Integer uid;
    private Integer aid;

    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
