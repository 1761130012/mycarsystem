package com.service;

import com.vo.SystemRole;

import java.util.List;

public interface SystemRoleService {
    List<SystemRole> queryAllRole();

    boolean updatePowerRoleId(int roleId, Integer[] menuIds);

    List<String> queryStaffMenuIdCode(Integer menuId, String staffId);

    List<SystemRole> queryAll();

    boolean insertRole(SystemRole role);

    SystemRole queryRoleId(Integer id);

    boolean updateRoleId(SystemRole role);

    List<SystemRole> queryAllRoleA(String staffId);

    boolean updateStaffRoleArrayStaffId(SystemRole role);

    boolean deleteId(Integer id);
}
