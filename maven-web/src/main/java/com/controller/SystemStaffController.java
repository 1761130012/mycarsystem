package com.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service.SystemStaffService;
import com.vo.PageVo;
import com.vo.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/systemStaff")
public class SystemStaffController {
    @Autowired
    private SystemStaffService staffService;

    @RequestMapping("/queryPageVo")
    @ResponseBody
    public PageVo<SystemStaff> queryPageVo(SystemStaff staff, Integer page, Integer rows) {
        return staffService.queryPageVo(staff, page, rows);
    }
}
