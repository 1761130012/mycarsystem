package com.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("system_staff")
public class SystemStaff extends FormatTime {
    @TableId
    private String id;//员工账户
    private String name;//员工名称
    private String pwd;//员工密码
    private String phone;//员工电话
    private String identityCard;//员工身份证
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;//入职时间
}
