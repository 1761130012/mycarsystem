package com.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("system_menu_code")
public class SystemMenuCode {
    @TableId
    private String code;//识别码
    private String name;//名称
}
