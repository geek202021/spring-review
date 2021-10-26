package com.jun;

import com.jun.proxy.User;
import com.jun.proxy.UserService;
import com.jun.proxy.UserServiceImpl;
import com.jun.proxy.UserServiceProxy;
import org.junit.Test;

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
}
