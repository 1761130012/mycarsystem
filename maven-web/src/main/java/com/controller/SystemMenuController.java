package com.controller;

import com.service.SystemMenuService;
import com.vo.SystemMenu;
import com.vo.SystemMenuCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/systemMenu")
public class SystemMenuController {
    @Autowired
    private SystemMenuService systemMenuService;

    /**
     * 根据 员工 id 查询 角色 在 查询 菜单
     */
    @RequestMapping("/queryListMenuStaff")
    @ResponseBody
    public List<SystemMenu> queryListMenuStaff(HttpServletRequest request) {
        //进行设置
        request.getSession().setAttribute("staffId", "1761130012");

        //进行查询
        return systemMenuService.queryListMenuStaff((String) request.getSession().getAttribute("staffId"));
    }

    @RequestMapping("/queryListMenuStaffBath")
    @ResponseBody
    public List<SystemMenu> queryListMenuStaffBath(@RequestParam(defaultValue = "0") int id) {
        return systemMenuService.queryListMenuStaffBath(id);
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<SystemMenu> queryAll() {
        return systemMenuService.queryAll(0);
    }

    @RequestMapping("/insertMenu")
    @ResponseBody
    public boolean insertMenu(SystemMenu menu){
        return systemMenuService.insertMenu(menu);
    }

    @RequestMapping("/updateMenu")
    @ResponseBody
    public boolean updateMenu(SystemMenu menu){
        return systemMenuService.updateMenu(menu);
    }

    @RequestMapping("/queryMenuId")
    @ResponseBody
    public SystemMenu queryMenuId(int id){
        return systemMenuService.queryMenuId(id);
    }

    @RequestMapping("/deleteMenuId")
    @ResponseBody
    public boolean deleteMenuId(int id){
        return systemMenuService.deleteMenuId(id);
    }

    @RequestMapping("/queryAllCode")
    @ResponseBody
    public List<SystemMenuCode> queryAllCode(){
        return systemMenuService.queryAllCode();
    }

    /**
     * 根据 id  查询 本 id 的父id  在 以父 id 查询 有 相同 父 id 的菜单
     */
    @RequestMapping("/queryMenuParentId")
    @ResponseBody
    public List<SystemMenu> queryMenuParentId(Integer id){
        return systemMenuService.queryMenuParentId(id);
    }
}
