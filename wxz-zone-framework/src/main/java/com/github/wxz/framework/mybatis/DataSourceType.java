package com.github.wxz.framework.mybatis;

/**
 * @author xianzhi.wang
 * @date 2018/1/11 -11:00
 */
public enum DataSourceType {
    READ("read", "从库"),
    WRITE("write", "主库");

    private String type;

    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
