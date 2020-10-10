package com.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("system_menu")
public class SystemMenu {
    @TableId(type = IdType.AUTO)
    private Integer id;//id
    @TableField(value = "text")
    private String text;//菜单名
    @TableField(value = "url")
    private String url;//地址
    @TableField(value = "parentIds")
    private Integer parentIds;//父菜单id

    @TableField(exist = false)
    private String code;//辨别码
    @TableField(exist = false)
    private List<SystemMenu> nodes;//下一级的菜单
    @TableField(exist = false)
    private SystemMenuState state;//是否选中
    @TableField(exist = false)
    private int[] tags;//徽章
}
