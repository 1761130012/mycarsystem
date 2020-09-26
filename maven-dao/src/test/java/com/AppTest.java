package com;

import com.dao.TestUserDao;
import com.vo.TestUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class AppTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\盖世神龙\\S3\\项目与考试\\第 3 阶段考试\\mycarsystem\\maven-dao\\src\\test\\resources/1.jpg");
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[65535];
        inputStream.read(bytes);

        int a = context.getBean(TestUserDao.class).insertUser(new TestUser("李四", bytes));
        System.out.println(a);

        inputStream.close();
    }

    @Test
    public void test2() {
        List<TestUser> testUser=context.getBean(TestUserDao.class).queryAll();
        System.out.println(testUser);
    }
}
