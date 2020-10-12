package com.controller;

import com.service.SystemRoleService;
import com.vo.SystemRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/updatePowerRoleId")
    @ResponseBody
    public boolean updatePowerRoleId(@RequestBody SystemRole role) {
        return roleService.updatePowerRoleId(role.getId(), role.getMenuIds());
    }

    @RequestMapping("/queryStaffMenuIdCode")
    @ResponseBody
    public List<String> queryStaffMenuIdCode(Integer menuId, HttpServletRequest request) {
        return roleService.queryStaffMenuIdCode(menuId, (String) request.getSession().getAttribute("staffId"));
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<SystemRole> queryAll() {
        return roleService.queryAll();
    }

    @RequestMapping("/insertRole")
    @ResponseBody
    public boolean insertRole(SystemRole role) {
        return roleService.insertRole(role);
    }

    @RequestMapping("/queryRoleId")
    @ResponseBody
    public SystemRole queryRoleId(Integer id) {
        return roleService.queryRoleId(id);
    }

    @RequestMapping("/updateRoleId")
    @ResponseBody
    public boolean updateRoleId(SystemRole role) {
        return roleService.updateRoleId(role);
    }

    @RequestMapping("/queryAllRoleA")
    @ResponseBody
    public List<SystemRole> queryAllRoleA(@RequestParam(defaultValue = "0") String staffId) {
        return roleService.queryAllRoleA(staffId);
    }

    @RequestMapping("/updateStaffRoleArrayStaffId")
    @ResponseBody
    public boolean updateStaffRoleArrayStaffId(@RequestBody SystemRole role) {
        return roleService.updateStaffRoleArrayStaffId(role);
    }

    @RequestMapping("/deleteId")
    @ResponseBody
    public boolean deleteId(Integer id) {
        return roleService.deleteId(id);
    }
}
