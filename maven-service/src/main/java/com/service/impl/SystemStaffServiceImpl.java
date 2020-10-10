package com.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dao.SystemStaffDao;
import com.service.SystemStaffService;
import com.vo.PageVo;
import com.vo.SystemMenu;
import com.vo.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SystemStaffServiceImpl implements SystemStaffService {
    @Autowired
    private SystemStaffDao staffDao;
    @Autowired
    private PageVo<SystemStaff> pageVo;

    @Override
    public PageVo<SystemStaff> queryPageVo(SystemStaff staff, Integer page, Integer rows) {
        pageVo.setCurrent(page);
        pageVo.setSize(rows);
        //进行 查询
        staffDao.selectPageVo(pageVo, staff);
        pageVo.setRows(pageVo.getRecords());
        return pageVo;
    }
}
