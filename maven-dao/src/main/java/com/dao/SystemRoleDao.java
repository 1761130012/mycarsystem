package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vo.SystemRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SystemRoleDao extends BaseMapper<SystemRole> {
    /**
     * 根据 员工 id 查询 所归属的 菜单id 不重复
     *
     * @param staffId 员工 id
     * @return
     */
    List<Integer> selectListMenuIdStaffId(String staffId);

    /**
     * 根据 角色 id 进行 查询 所属菜单id
     */
    List<Integer> selectMenuRoleId(int roleId);

    /**
     * 删除  角色与 菜单表 的 权限  根据 角色 id
     */
    int deleteRoleMenuRoleId(int roleId);

    int insertBath(@Param("roleId") int roleId, @Param("menuIds") Integer[] menuIds);

    List<Integer> selectListMenuIdStaffIdMenuId(@Param("staffId") String staffId,@Param("menuId") Integer menuId);
}
