package com.dao;

import com.vo.TestUser;

import java.util.List;

public interface TestUserDao {

    int insertUser(TestUser testUser);

    TestUser getImage();

    List<TestUser> queryAll();
}
