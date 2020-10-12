package com.service.impl;

import com.dao.SystemMenuCodeDao;
import com.dao.SystemMenuDao;
import com.dao.SystemRoleDao;
import com.service.SystemMenuService;
import com.vo.SystemMenu;
import com.vo.SystemMenuCode;
import com.vo.SystemMenuState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemMenuServiceImpl implements SystemMenuService {
    @Autowired
    private SystemMenuDao menuDao;
    @Autowired
    private SystemRoleDao roleDao;
    @Autowired
    private SystemMenuCodeDao codeDao;

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

    @Override
    public List<SystemMenu> queryListMenuStaffBath(int roleId) {
        List<Integer> menuIds = null;
        //查询 出 所有的 id
        if (roleId != 0) menuIds = roleDao.selectMenuRoleId(roleId);

        //查询 父菜单
        List<SystemMenu> menuList = menuDao.selectMenuParentIdId(0);
        //根据 角色 id 和菜单 id  查询 是否 匹配 匹配 进行 选中
        for (SystemMenu menu : menuList) {
            //选中
            if (menuIds != null && menuIds.contains(menu.getId())) {
                menu.setState(new SystemMenuState(true));
            }
            //进行 找子菜单
            List<SystemMenu> menuList1 = menuDao.selectMenuParentIdId(menu.getId());
            //进行 添加
            menu.setNodes(menuList1);
            menu.setTags(new int[]{menuList1.size()});

            for (SystemMenu menu1 : menuList1) {
                //选中
                if (menuIds != null && menuIds.contains(menu1.getId())) {
                    menu1.setState(new SystemMenuState(true));
                }
                //进行 找子菜单
                List<SystemMenu> menuList2 = menuDao.selectMenuParentIdId(menu1.getId());
                //进行 添加
                menu1.setNodes(menuList2);
                menu1.setTags(new int[]{menuList2.size()});

                for (SystemMenu menu2 : menuList2) {
                    //选中
                    if (menuIds != null && menuIds.contains(menu2.getId())) {
                        menu2.setState(new SystemMenuState(true));
                    }
                    menu2.setNodes(null);
                }
            }
        }
        return menuList;
    }

    @Override
    public List<SystemMenu> queryAll(int parentId) {
        List<SystemMenu> menus = menuDao.selectMenuParentIdId(parentId);
        if (menus.isEmpty()) {
            return menus;
        }
        for (SystemMenu menu : menus) {
            List<SystemMenu> m = queryAll(menu.getId());
            menu.setNodes(m);
            menu.setTags(new int[]{m.size()});
        }
        return menus;
    }



    @Override
    public boolean insertMenu(SystemMenu menu) {
        return menuDao.insert(menu) > 0;
    }

    @Override
    public boolean updateMenu(SystemMenu menu) {
        return menuDao.updateById(menu) > 0;
    }

    @Override
    public SystemMenu queryMenuId(int id) {
        return menuDao.selectById(id);
    }

    @Override
    public boolean deleteMenuId(int id) {
        return menuDao.deleteById(id) > 0;
    }

    @Override
    public List<SystemMenuCode> queryAllCode() {
        return codeDao.selectList(null);
    }

    @Override
    public List<SystemMenu> queryMenuParentId(Integer id) {
        return menuDao.selectMenuParentId(id);
    }
}
