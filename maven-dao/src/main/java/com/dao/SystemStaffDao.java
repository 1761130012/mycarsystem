package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vo.PageVo;
import com.vo.SystemMenu;
import com.vo.SystemStaff;
import org.apache.ibatis.annotations.Param;

public interface SystemStaffDao extends BaseMapper<SystemStaff> {
    /**
     * 进行分页
     */
    PageVo<SystemStaff> selectPageVo(@Param("page") Page<SystemStaff> page, @Param("staff")SystemStaff staff);
}
