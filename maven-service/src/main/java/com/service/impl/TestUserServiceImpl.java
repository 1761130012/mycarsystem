package com.service.impl;

import com.dao.TestUserDao;
import com.service.TestUserService;
import com.vo.TestUser;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    private TestUserDao testUserDao;


    @Override
    public TestUser getImage() {
        return testUserDao.getImage();
    }

    @Override
    public List<TestUser> queryAll() {
        return testUserDao.queryAll();
    }
}
