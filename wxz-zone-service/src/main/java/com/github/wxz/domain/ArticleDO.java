package com.github.wxz.domain;

import java.util.Date;

/**
 * service 层
 *
 * @author xianzhi.wang
 * @date 2018/1/15 -10:51
 */
public class ArticleDO {

    private Integer id;
    private Integer uid;
    private String uName;
    private String category;
    private String tag;
    private String title;
    private String img;
    /**
     * simple content
     */
    private String sent;
    private String content;
    private Integer top;
    private Integer chosen;
    private Date create;
    private Date update;

    public Integer getChosen() {
        return chosen;
    }

    public void setChosen(Integer chosen) {
        this.chosen = chosen;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
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
        return "ArticleDO{" +
                "id=" + id +
                ", uid=" + uid +
                ", uName='" + uName + '\'' +
                ", category='" + category + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", sent='" + sent + '\'' +
                ", content='" + content + '\'' +
                ", top=" + top +
                ", create=" + create +
                ", update=" + update +
                '}';
    }
}
