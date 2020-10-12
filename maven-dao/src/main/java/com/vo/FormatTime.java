package com.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

public class FormatTime {
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date startTime;
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date endTime;
}
