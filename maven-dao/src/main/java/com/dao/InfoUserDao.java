package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vo.InfoUser;
import com.vo.PageVo;
import org.apache.ibatis.annotations.Param;


public interface InfoUserDao extends BaseMapper<InfoUser> {
    PageVo<InfoUser> selectPageVo(@Param("pageVo") PageVo<InfoUser> pageVo, @Param("infoUser") InfoUser infoUser);
}
