package com.jun.factory;

import com.jun.proxy.User;

/**
 * Spring工厂对于代理的加工
 * @author HuangJun7
 * @date 2021-10-27 15:05
 */
public class UserServiceImpl implements UserService{
    @Override
    public void login(String name, String password) {
        System.out.println("UserServiceImpl login");
    }

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl register");
    }
}
