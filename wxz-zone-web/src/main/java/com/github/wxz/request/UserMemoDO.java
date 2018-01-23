package com.github.wxz.request;

/**
 * @author xianzhi.wang
 * @date 2018/1/22 -11:14
 */
public class UserMemoDO {
    private Integer aid;
    private Integer floor;
    private Integer parent;
    private String memo;
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserMemoDO{" +
                "aid=" + aid +
                ", floor=" + floor +
                ", parent=" + parent +
                ", memo='" + memo + '\'' +
                ", type=" + type +
                '}';
    }
}
