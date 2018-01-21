package com.github.wxz.entity;

import java.util.Date;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 16:50
 * @email: xianzhi@eastmoney.com
 */
public class ArticleAccessLog {
    private Integer id ;
    private Integer uid;
    private Integer aid;
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
