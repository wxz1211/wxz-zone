package com.github.wxz.common.util;

import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/14
 * @time: 19:52
 * @email: xianzhi@eastmoney.com
 */
public class PageUtil<T> {
    public static final int DEFAULT_SIZE = 10;

    private int size;
    private List<T> dataList;
    private int currentPage;
    private int pageSize;
    private int begin;


    public PageUtil(List<T> dataList, int currentPage) {
        this.dataList = dataList;
        this.currentPage = currentPage;
        this.size = dataList.size();
    }


    public static <T> PageUtil<T> instance(List<T> dataList, int begin, int pageSize) {
        if (pageSize == DEFAULT_SIZE) {
            pageSize = DEFAULT_SIZE;
        }
        int currentPage;
        currentPage = begin / pageSize;
        return instance(dataList, currentPage);
    }

    public static <T> PageUtil<T> instance(List<T> dataList, int currentPage) {
        return new PageUtil<>(dataList, currentPage);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }
}
