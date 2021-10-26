package com.jun.proxy;

/**
 * 静态代理：原始类：只负责核心业务功能
 * @author HuangJun7
 * @date 2021-10-26 22:37
 */
public class UserServiceImpl implements UserService{
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算 + DAO");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login 业务运算 + DAO");
        return true;
    }
}
