package com.service.impl;

import com.dao.InfoUserDao;
import com.service.InfoUserService;
import com.vo.InfoUser;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoUserServiceImpl implements InfoUserService {
    @Autowired
    private InfoUserDao userDao;

    @Override
    public PageVo<InfoUser> queryPageVo(InfoUser infoUser, PageVo<InfoUser> pageVo) {
        return userDao.selectPageVo(pageVo, infoUser);
    }

    @Override
    public boolean insertInfo(InfoUser infoUser) {
        return userDao.insert(infoUser) > 0;
    }

    @Override
    public InfoUser queryInfoUserId(String id) {
        return userDao.selectById(id);
    }

    @Override
    public boolean updateInfoUser(InfoUser infoUser) {
        return userDao.updateById(infoUser) > 0;
    }

    @Override
    public boolean deleteId(String id) {
        return userDao.deleteById(id) > 0;
    }
}
