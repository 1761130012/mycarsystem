package com.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.List;

//@JsonIgnoreProperties(value = "handler")//解决 延迟 加载 的引用
@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class PageVo<T> extends Page<T>{
    private List<T> rows;
}
