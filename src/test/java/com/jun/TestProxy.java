package com.jun;

import com.jun.proxy.User;
import com.jun.proxy.UserService;
import com.jun.proxy.UserServiceImpl;
import com.jun.proxy.UserServiceProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

/**
 * @author HuangJun7
 * @date 2021-10-26 22:46
 */
public class TestProxy {
    /**
     * 用于测试静态代理的代码
     */
    @Test
    public void test1() {
        UserService userService = new UserServiceProxy();
        userService.login("jun", "hrj");
        userService.register(new User());
    }
    /**
     * 用于Spring的动态代理
     */
    @Test
    public void test2() {
        //1.Spring 的工厂通过原始对象的 id 值获得的是代理对象
        //2.获得代理对象后，可以通过声明接口类型，进行对象的存储
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/proxy.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("jun", "1234");
        userService.register(new User());
    }
}
