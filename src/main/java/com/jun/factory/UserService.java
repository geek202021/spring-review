package com.jun.factory;

import com.jun.proxy.User;

/**
 * Spring工厂对于代理的加工
 * @author HuangJun7
 * @date 2021-10-27 15:04
 */
public interface UserService {
    void login(String name, String password);

    void register(User user);
}
