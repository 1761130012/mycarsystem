package com.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service.SystemStaffService;
import com.vo.PageVo;
import com.vo.SystemRole;
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
    public PageVo<SystemStaff> queryPageVo(SystemStaff staff,PageVo<SystemStaff> pageVo) {
        return staffService.queryPageVo(staff, pageVo);
    }

    @RequestMapping("/insertStaff")
    @ResponseBody
    public boolean insertStaff(SystemStaff staff) {
        return staffService.insertStaff(staff);
    }

    @RequestMapping("/queryStaffId")
    @ResponseBody
    public SystemStaff queryStaffId(String id) {
        return staffService.queryStaffId(id);
    }

    @RequestMapping("/updateStaffId")
    @ResponseBody
    public boolean updateStaffId(SystemStaff staff) {
        return staffService.updateStaffId(staff);
    }

    @RequestMapping("/deleteStaffId")
    @ResponseBody
    public boolean deleteStaffId(String id) {
        return staffService.deleteStaffId(id);
    }

    @RequestMapping("/queryAllPageVo")
    @ResponseBody
    public PageVo<SystemStaff> queryAllPageVo(SystemStaff staff,PageVo<SystemStaff> pageVo) {
        return staffService.queryAllPageVo(staff,pageVo);
    }

}
