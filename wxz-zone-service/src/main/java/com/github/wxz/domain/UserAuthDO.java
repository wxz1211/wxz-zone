package com.github.wxz.domain;

import java.io.Serializable;

/**
 * redis UserAuthDO
 * @author xianzhi.wang
 * @date 2018/1/11 -10:37
 */
public class UserAuthDO implements Serializable {

    private String wxzId;
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

    /**
     * 加密后的密码secret
     */
    private String secret;

    private String pass;

    public String getWxzId() {
        return wxzId;
    }

    public void setWxzId(String wxzId) {
        this.wxzId = wxzId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UserAuthDO{" +
                "wxzId='" + wxzId + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", img='" + img + '\'' +
                ", mobile='" + mobile + '\'' +
                ", secret='" + secret + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
