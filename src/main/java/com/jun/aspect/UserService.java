package com.jun.aspect;

import com.jun.proxy.User;

/**
 * @author HuangJun7
 * @date 2021-10-27 15:24
 */
public interface UserService {
    void register(User user);

    boolean login(String name, String password);
}
