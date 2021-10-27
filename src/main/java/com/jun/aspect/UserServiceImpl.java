package com.jun.aspect;

import com.jun.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author HuangJun7
 * @date 2021-10-27 15:25
 */
public class UserServiceImpl implements UserService, ApplicationContextAware {
    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl register");
        // this.login("jun", "123456"); // 这么写调用的是本类的 login 方法, 即原始对象的 login 方法
        // 为什么不在这里创建一个工厂获取代理对象呢？
        // 因为Spring的工厂是重量级资源, 一个应用中应该只创建一个工厂.
        // 因此我们必须通过 ApplicationContextAware 拿到已经创建好的工厂
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("jun", "123456");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login 业务运算 + DAO");
        return false;
    }
}
