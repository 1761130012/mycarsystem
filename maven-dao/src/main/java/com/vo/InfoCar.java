package com.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("info_car")
public class InfoCar {
    @TableId(type = IdType.AUTO)
    private Integer id;//id
    private String name;//车辆名称
    @TableField(value = "carTypeId")
    private Integer carTypeId;//品牌id
    @TableField(value = "car_code")
    private String carCode;//车牌号
    @TableField(value = "image_url")
    private String imageUrl;//图片地址
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;//生产时间
    private String remark;//备注信息

    @TableField(exist = false)
    private InfoCarType carType;//品牌类型
}
