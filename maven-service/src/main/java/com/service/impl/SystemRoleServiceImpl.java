package com.service.impl;

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
}
