package com.service;

import com.vo.SystemMenu;
import com.vo.SystemMenuCode;

import java.util.List;

public interface SystemMenuService {
    List<SystemMenu> queryListMenuStaff(String staffId);

    List<SystemMenu> queryListMenuStaffBath(int roleId);

    List<SystemMenu> queryAll(int parentId);

    String queryMenuTitleParentId(int parentIds);

    boolean insertMenu(SystemMenu menu);

    boolean updateMenu(SystemMenu menu);

    SystemMenu queryMenuId(int id);

    boolean deleteMenuId(int id);

    List<SystemMenuCode> queryAllCode();
}
