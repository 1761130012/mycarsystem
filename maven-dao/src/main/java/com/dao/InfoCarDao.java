package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vo.InfoCar;
import com.vo.PageVo;
import org.apache.ibatis.annotations.Param;

public interface InfoCarDao extends BaseMapper<InfoCar> {
    PageVo<InfoCar> selectPageVo(@Param("pageVo") PageVo<InfoCar> pageVo, @Param("car") InfoCar car);
}
