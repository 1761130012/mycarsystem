package com.service;

import com.vo.SystemMenu;

import java.util.List;

public interface SystemMenuService {
    List<SystemMenu> queryListMenuStaff(String staffId);
}
