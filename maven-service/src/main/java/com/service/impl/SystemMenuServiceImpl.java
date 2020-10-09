package com.service.impl;

import com.dao.SystemMenuDao;
import com.dao.SystemRoleDao;
import com.service.SystemMenuService;
import com.vo.SystemMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemMenuServiceImpl implements SystemMenuService {
    @Autowired
    private SystemMenuDao menuDao;
    @Autowired
    private SystemRoleDao roleDao;

    @Override
    public List<SystemMenu> queryListMenuStaff(String staffId) {
        //根据 员工 查询 角色 有什么 菜单 的id
        List<Integer> menuIds = roleDao.selectListMenuIdStaffId(staffId);

        //进行 组装
        List<SystemMenu> menuList = menuDao.selectMenuId(0, menuIds);
        for (SystemMenu s : menuList) {
            s.setNodes(menuDao.selectMenuId(s.getId(), menuIds));
        }
        return menuList;
    }
}
