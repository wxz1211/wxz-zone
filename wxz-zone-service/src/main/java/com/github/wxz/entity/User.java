package com.github.wxz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * mysql数据库层面
 * @author xianzhi.wang
 * @date 2018/1/10 -18:06
 */
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * email
     */
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String img;

    /**
     * 电话号码
     */
    private String mobile;

    private String pass;

    /**
     * 创建时间
     */
    private Date create;

    /**
     * 更新时间
     */
    private Date update;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
