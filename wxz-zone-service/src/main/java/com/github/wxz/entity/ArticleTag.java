package com.github.wxz.entity;

import java.util.Date;

/**
 * @author: wangxianzhi
 * @date: 2018/1/20
 * @time: 15:44
 * @email: xianzhi@eastmoney.com
 */
public class ArticleTag {
    private Integer id;
    private Integer tag;
    private String name;
    private Date create;
    private Date update;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
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
