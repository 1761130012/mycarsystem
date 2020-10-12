package com;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dao.InfoUserDao;
import com.dao.SystemMenuDao;
import com.dao.SystemRoleDao;
import com.dao.SystemStaffDao;
import com.vo.InfoUser;
import com.vo.PageVo;
import com.vo.SystemMenu;
import com.vo.SystemStaff;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

    @Test
    public void test1() throws IOException {
        PageVo<InfoUser> iPage = context.getBean(InfoUserDao.class).selectPageVo(new PageVo<InfoUser>(1, 2), null);
        System.out.println(iPage.getRows());
    }

}
