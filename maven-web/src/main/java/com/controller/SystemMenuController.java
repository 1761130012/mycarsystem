package com.controller;

import com.service.SystemMenuService;
import com.vo.SystemMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/system")
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
}
