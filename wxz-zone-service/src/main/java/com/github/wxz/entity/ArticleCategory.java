package com.github.wxz.entity;

import java.util.Date;

/**
 * @author: wangxianzhi
 * @date: 2018/1/20
 * @time: 15:43
 * @email: xianzhi@eastmoney.com
 */
public class ArticleCategory {
    private Integer id;
    private Integer type;
    private String name;
    private Date create;
    private Date update;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
