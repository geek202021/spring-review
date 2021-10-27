package com.jun;

import com.jun.aspect.UserService;
import com.jun.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuangJun7
 * @date 2021-10-27 15:40
 */
public class TestAspectJProxy {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/aspectJ.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("jun", "123");
        userService.register(new User());
    }
}
