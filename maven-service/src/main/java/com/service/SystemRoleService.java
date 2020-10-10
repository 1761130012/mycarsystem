package com.service;

import com.vo.SystemRole;

import java.util.List;

public interface SystemRoleService {
    List<SystemRole> queryAllRole();

    boolean updatePowerRoleId(int roleId,Integer[] menuIds);

    List<String> queryStaffMenuIdCode(Integer menuId,String staffId);
}
