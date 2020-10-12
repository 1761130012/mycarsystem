package com.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("info_user")
public class InfoUser {
    @TableId
    private String id;//用户id
    private String pwd;//密码
    private String name;//名称
    private String code;//身份证号
    @TableField(value = "car_code")
    private String carCode;//驾驶证号
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;//创建时间
}
