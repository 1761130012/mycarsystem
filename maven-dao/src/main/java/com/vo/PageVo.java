package com.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.List;

//@JsonIgnoreProperties(value = "handler")//解决 延迟 加载 的引用
@EqualsAndHashCode(callSuper = true)
@Data
public class PageVo<T> extends Page<T> {
    private List<T> rows;
    public PageVo() {

    }

    public PageVo(long current, long size) {
        super(current, size);
    }

    //重写
    @Override
    public Page<T> setRecords(List<T> records) {
        setRows(records);
        return super.setRecords(records);
    }
}
