package com.service.impl;

import com.dao.SystemMenuDao;
import com.dao.SystemRoleDao;
import com.service.SystemRoleService;
import com.vo.SystemRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemRoleServiceImpl implements SystemRoleService {
    @Autowired
    private SystemRoleDao roleDao;
    @Autowired
    private SystemMenuDao menuDao;

    @Override
    public List<SystemRole> queryAllRole() {
        return roleDao.selectList(null);
    }

    @Override
    public boolean updatePowerRoleId(int roleId, Integer[] menuIds) {
        //根据 角色 id 先 删除 所有 的 权限
        roleDao.deleteRoleMenuRoleId(roleId);
        //进行 添加
        return roleDao.insertBath(roleId, menuIds) > 0;
    }

    @Override
    public List<String> queryStaffMenuIdCode(Integer menuId, String staffId) {
        List<Integer> menuIds = roleDao.selectListMenuIdStaffIdMenuId(staffId, menuId);
        return menuDao.selectListMenuIdCode(menuId, menuIds);
    }

    @Override
    public List<SystemRole> queryAll() {
        return roleDao.selectList(null);
    }

    @Override
    public boolean insertRole(SystemRole role) {
        return roleDao.insert(role) > 0;
    }

    @Override
    public SystemRole queryRoleId(Integer id) {
        return roleDao.selectById(id);
    }

    @Override
    public boolean updateRoleId(SystemRole role) {
        return roleDao.updateById(role) > 0;
    }

    @Override
    public List<SystemRole> queryAllRoleA(String staffId) {
        List<SystemRole> list = roleDao.selectList(null);
        if (!staffId.equals("0")) {
            List<Integer> roleIds = roleDao.selectRoleStaffId(staffId);

            for (SystemRole role : list) {
                for (Integer id : roleIds) {
                    if (role.getId().equals(id)) {
                        role.setCheckbox(true);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public boolean updateStaffRoleArrayStaffId(SystemRole role) {
        //进行删除
        roleDao.deleteStaffId(role.getStaffId());
        return roleDao.insertStaffRoleArrayStaffId(role.getStaffId(), role.getRoleIds()) > 0;
    }

    @Override
    public boolean deleteId(Integer id) {
        return roleDao.deleteById(id) > 0;
    }
}
