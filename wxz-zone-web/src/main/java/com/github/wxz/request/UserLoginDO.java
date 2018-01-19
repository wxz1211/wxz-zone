package com.github.wxz.request;

/**
 * UserLoginDO
 *
 * @author xianzhi.wang
 * @date 2018/1/17 -15:41
 */
public class UserLoginDO {

    private String mobile;
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginDO{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
