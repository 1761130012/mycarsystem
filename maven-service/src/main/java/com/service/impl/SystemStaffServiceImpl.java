package com.service.impl;

import com.dao.SystemStaffDao;
import com.service.SystemStaffService;
import com.vo.PageVo;
import com.vo.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemStaffServiceImpl implements SystemStaffService {
    @Autowired
    private SystemStaffDao staffDao;

    @Override
    public PageVo<SystemStaff> queryPageVo(SystemStaff staff, PageVo<SystemStaff> pageVo) {
        //进行 查询
        return staffDao.selectPageVo(pageVo, staff);
    }

    @Override
    public boolean insertStaff(SystemStaff staff) {
        return staffDao.insert(staff) > 0;
    }

    @Override
    public SystemStaff queryStaffId(String id) {
        return staffDao.selectById(id);
    }

    @Override
    public boolean updateStaffId(SystemStaff staff) {
        return staffDao.updateById(staff) > 0;
    }

    @Override
    public boolean deleteStaffId(String id) {
        return staffDao.deleteById(id) > 0;
    }

    @Override
    public PageVo<SystemStaff> queryAllPageVo(SystemStaff staff, PageVo<SystemStaff> pageVo) {
        //查询
        return staffDao.selectPageVo(pageVo, staff);
    }
}
