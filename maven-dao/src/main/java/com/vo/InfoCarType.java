package com.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class InfoCarType {
    @TableId
    private Integer id;//编号
    private String name;//品牌名
}
