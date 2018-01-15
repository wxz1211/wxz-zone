package com.github.wxz.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: wangxianzhi
 * @date: 2018/1/14
 * @time: 19:52
 * @email: xianzhi@eastmoney.com
 */
public class PaginationManage<T> {
    public static final int DEFAULT_SIZE_10 = 10;
    public static final int DEFAULT_SIZE_8 = 8;
    public static final int DEFAULT_SIZE_5 = 5;

    private int totalCount;
    private List<T> dataList = new ArrayList<>();
    private int pageNo;
    private int pageSize;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        if (dataList != null) {
            this.dataList = dataList;
        }
    }

    public void addAllData(Collection<T> collection) {
        if (collection == null) {
            return;
        }
        if (dataList == null) {
            dataList = new ArrayList<T>();
        }
        dataList.addAll(collection);
    }

    public void addData(T data) {
        if (dataList == null) {
            dataList = new ArrayList<T>();
        }
        dataList.add(data);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    private void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    private void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getMaxPageNo() {
        return totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize + 1);
    }

    public Integer getCurrentPageNo() {
        Integer maxPageNo = getMaxPageNo();
        Integer currentPage = pageNo <= maxPageNo ? pageNo : maxPageNo;
        return currentPage <= 0 ? 1 : currentPage;
    }

    public Integer getStartRow() {
        Integer currentPage = getCurrentPageNo();
        return (currentPage - 1) * pageSize + 1;
    }

    public Integer getEndRow() {
        Integer currentPage = getCurrentPageNo();
        return currentPage * pageSize;
    }

    public void setPageInfo(Integer pageNo, Integer pageSize) {
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    public Integer getPageShowStart() {
        Integer segmentSize = 5;
        Integer currentPage = getCurrentPageNo();
        Integer segmentIndex = (currentPage % segmentSize == 0) ? (currentPage / segmentSize)
                : (currentPage / segmentSize + 1);
        return (segmentIndex - 1) * segmentSize + 1;
    }

    public Integer getPageShowEnd() {
        Integer segmentSize = 5;
        Integer currentPage = getCurrentPageNo();
        Integer segmentIndex = (currentPage % segmentSize == 0) ? (currentPage / segmentSize)
                : (currentPage / segmentSize + 1);
        return segmentIndex * segmentSize;
    }

    public List<Integer> getPageShowList() {
        List<Integer> pageShowList = new ArrayList<>();
        Integer segmentSize = 5;
        Integer currentPage = getCurrentPageNo();
        Integer segmentIndex = (currentPage % segmentSize == 0) ? (currentPage / segmentSize)
                : (currentPage / segmentSize + 1);
        Integer start = (segmentIndex - 1) * segmentSize + 1;
        Integer end = segmentIndex * segmentSize;
        for (int i = start; i <= end; i++) {
            pageShowList.add(i);
        }
        return pageShowList;
    }

}
