package com;

import com.dao.SystemMenuDao;
import com.dao.SystemRoleDao;
import com.dao.SystemStaffDao;
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
         List list=context.getBean(SystemMenuDao.class).selectMenuId(0, Arrays.asList(1,2,3));
        System.out.println(list);
    }
}
