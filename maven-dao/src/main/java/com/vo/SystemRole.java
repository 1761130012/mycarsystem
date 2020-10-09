package com.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("system_role")
public class SystemRole {
    private Integer id;//角色id
    private String name;//角色名
    private String remark;//备注
}
