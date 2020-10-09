package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vo.SystemRole;

import java.util.List;


public interface SystemRoleDao extends BaseMapper<SystemRole> {
    /**
     * 根据 员工 id 查询 所归属的 菜单id 不重复
     * @param staffId 员工 id
     * @return
     */
    List<Integer> selectListMenuIdStaffId(String staffId);
}
