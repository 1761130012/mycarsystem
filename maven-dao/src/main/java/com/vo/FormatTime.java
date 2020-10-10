package com.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

public class FormatTime {
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date startTime;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date endTime;
}
