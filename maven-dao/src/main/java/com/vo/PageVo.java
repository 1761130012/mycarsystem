package com.vo;

import org.springframework.stereotype.Component;

import java.util.List;

//@JsonIgnoreProperties(value = "handler")//解决 延迟 加载 的引用
@Component
public class PageVo<T> {
    private T t;
    private List<T> rows;

    private Integer page;
    private Integer row;
    private Integer total;

    @Override
    public String toString() {
        return "PageVo{" +
                "t=" + t +
                ", rows=" + rows +
                ", page=" + page +
                ", row=" + row +
                ", total=" + total +
                '}';
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
