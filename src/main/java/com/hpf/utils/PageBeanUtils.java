package com.hpf.utils;

import java.util.List;

//分页数据封装
/*
    浏览器需要提供2个参数(当前页码和每页显示条数)
    服务器返回3个数据(一共多少条数据,一共多少页,每页显示的数据)
 */
public class PageBeanUtils<T> {
    private int pageNum;        //当前页码数
    private int pageSize;       //每页显示条数
    private int totalCount;     //总数据量
    private int totalPage;      //总页数
    private List<T> list;       //每页显示的数据

    public PageBeanUtils() {

    }

    public PageBeanUtils(int pageNum, int pageSize, int totalCount, int totalPage, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBeanUtils{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }

}
