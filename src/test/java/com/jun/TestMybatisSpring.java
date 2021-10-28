package com.jun;

import com.jun.dao.UserDAO;
import com.jun.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuangJun7
 * @date 2021-10-28 13:00
 */
public class TestMybatisSpring {
    //用于测试Spring整合Mybatis
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/mybatis-spring.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        User user = new User();
        user.setName("jelly");
        user.setPassword("999");
        userDAO.save(user);
    }
}
