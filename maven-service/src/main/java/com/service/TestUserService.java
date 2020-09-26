package com.service;

import com.vo.TestUser;

import java.util.List;

public interface TestUserService {
    TestUser getImage();

    List<TestUser> queryAll();
}
