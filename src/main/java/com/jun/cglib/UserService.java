package com.jun.cglib;

import com.jun.proxy.User;

/**
 * @author HuangJun7
 * @date 2021-10-27 13:53
 */
public class UserService {
    public void login(String name, String password) {
        System.out.println("原始类的login方法");
    }

    public void register(User user) {
        System.out.println("原始类的register方法");
    }
}
