package com.github.wxz.entity;

import java.util.Date;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -18:06
 */
public class User {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 密码
     */
    private String pass;
    /**
     * 昵称
     */
    private String nick;
    /**
     * 用户头像
     */
    private String img;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 创建时间
     */
    private Date create;
    /**
     * 更新时间
     */
    private Date update;

    /**
     * 最后登录时间
     */
    private Date login;

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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

    public Date getLogin() {
        return login;
    }

    public void setLogin(Date login) {
        this.login = login;
    }
}
