package com.github.wxz.domain;

import java.util.Date;
import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/21
 * @time: 20:07
 * @email: xianzhi@eastmoney.com
 */
public class ArticleMemoDO {
    private Integer id;
    private Integer uid;
    private String uName;
    private String img;
    private Integer aid;
    private Integer floor;
    private Integer parent;
    private String memo;
    private Date create;
    private Date update;
    private List<ArticleMemoSecondDO> articleMemoSecondDOList;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<ArticleMemoSecondDO> getArticleMemoSecondDOList() {
        return articleMemoSecondDOList;
    }

    public void setArticleMemoSecondDOList(List<ArticleMemoSecondDO> articleMemoSecondDOList) {
        this.articleMemoSecondDOList = articleMemoSecondDOList;
    }

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

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

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

    @Override
    public String toString() {
        return "ArticleMemoDO{" +
                "id=" + id +
                ", uid=" + uid +
                ", uName='" + uName + '\'' +
                ", aid=" + aid +
                ", floor=" + floor +
                ", parent=" + parent +
                ", memo='" + memo + '\'' +
                ", create=" + create +
                ", update=" + update +
                '}';
    }
}
