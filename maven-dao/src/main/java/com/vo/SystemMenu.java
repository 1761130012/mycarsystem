package com.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("system_menu")
public class SystemMenu {
    private Integer id;//id
    private String text;//菜单名
    private String code;//辨别码
    private String url;//地址
    private Integer parentId;//父菜单id

    private List<SystemMenu> nodes;//下一级的菜单

}
