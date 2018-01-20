package com.github.wxz.request;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/20
 * @time: 14:31
 * @email: xianzhi@eastmoney.com
 */
public class UserArticleDO {
    private String content;
    private String sent;
    private String title;
    private String img;
    private List<String> tag;
    private String category;
    private Integer top;
    private Integer chosen;

    public Integer getChosen() {
        return chosen;
    }

    public void setChosen(Integer chosen) {
        this.chosen = chosen;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
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


    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "UserArticleDO{" +
                "content='" + content + '\'' +
                ", sent='" + sent + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", tag=" + tag +
                ", category='" + category + '\'' +
                ", top=" + top +
                '}';
    }
}
