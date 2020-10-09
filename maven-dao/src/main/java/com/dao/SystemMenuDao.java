package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vo.SystemMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMenuDao extends BaseMapper<SystemMenu> {

    List<SystemMenu> selectMenuId(@Param("parentId") int parentId, @Param("menuId") List<Integer> menuId);
}
