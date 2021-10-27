package com.jun;

import com.jun.factory.UserService;
import com.jun.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuangJun7
 * @date 2021-10-27 15:17
 */
public class TestBeanPostProcessor {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/factory.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("jun", "123");
        userService.register(new User());
    }
}
