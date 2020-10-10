package com.controller;

import com.service.SystemRoleService;
import com.vo.SystemRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/systemRole")
public class SystemRoleController {
    @Autowired
    private SystemRoleService roleService;

    /**
     * 查询 所有的 角色
     */
    @RequestMapping("/queryAllRole")
    @ResponseBody
    public List<SystemRole> queryAllRole() {
        return roleService.queryAllRole();
    }

    @RequestMapping(value = "/updatePowerRoleId")
    @ResponseBody
    public boolean updatePowerRoleId(@RequestBody SystemRole role) {
        return roleService.updatePowerRoleId(role.getId(),role.getMenuIds());
    }
}
