package com.github.wxz.request;

/**
 * UserSignDO
 *
 * @author xianzhi.wang
 * @date 2018/1/17 -15:42
 */
public class UserSignDO {

    private String name;
    private String mobile;
    private String email;
    private Integer sex;
    private String password;
    private String rePassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    @Override
    public String toString() {
        return "UserSignDO{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", rePassword='" + rePassword + '\'' +
                '}';
    }
}
