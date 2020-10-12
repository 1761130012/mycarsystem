package com.controller;

import com.dao.InfoUserDao;
import com.service.InfoUserService;
import com.vo.InfoUser;
import com.vo.PageVo;
import com.vo.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/infoUser")
public class InfoUserController {
    @Autowired
    private InfoUserService userService;

    @RequestMapping("/queryPageVo")
    @ResponseBody
    public PageVo<InfoUser> queryPageVo(InfoUser infoUser,PageVo<InfoUser> pageVo){
        return userService.queryPageVo(infoUser, pageVo);
    }

    @RequestMapping("/insertInfo")
    @ResponseBody
    public boolean insertInfo(InfoUser infoUser) {
        return userService.insertInfo(infoUser);
    }

    @RequestMapping("/queryInfoUserId")
    @ResponseBody
    public InfoUser queryInfoUserId(String id){
        return userService.queryInfoUserId(id);
    }

    @RequestMapping("/updateInfoUser")
    @ResponseBody
    public boolean updateInfoUser(InfoUser infoUser) {
        return userService.updateInfoUser(infoUser);
    }

    @RequestMapping("/deleteId")
    @ResponseBody
    public boolean deleteId(String id) {
        return userService.deleteId(id);
    }
}
