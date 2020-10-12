package com.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("system_role")
public class SystemRole {
    @TableId(type = IdType.AUTO)
    private Integer id;//角色id
    private String name;//角色名
    private String remark;//备注

    @TableField(exist = false)
    private Integer[] menuIds;//菜单id
    @TableField(exist = false)
    private boolean checkbox;//是否选中
    @TableField(exist = false)
    private String staffId;
    @TableField(exist = false)
    private List<Integer> roleIds;
}
