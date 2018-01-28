package com.github.wxz.framework.netease;

/**
 * @author: wangxianzhi
 * @date: 2018/1/28
 * @time: 16:40
 * @email: xianzhi@eastmoney.com
 */
public class NetEaseSearchDO
{
    private Integer limit;
    private Integer offset;
    private Integer type;
    private String word;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
