package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vo.PageVo;
import com.vo.SystemMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMenuDao extends BaseMapper<SystemMenu> {

    List<SystemMenu> selectMenuId(@Param("parentId") int parentId, @Param("menuId") List<Integer> menuId);

    List<SystemMenu> selectMenuParentIdId(int parentId);

    PageVo<SystemMenu> selectPageVo(@Param("page") PageVo<SystemMenu> page, @Param("menu") SystemMenu menu);

    List<String> selectListMenuIdCode(@Param("parentId") int parentId, @Param("menuIds") List<Integer> menuIds);

    List<SystemMenu> selectMenuParentId(Integer id);
}
