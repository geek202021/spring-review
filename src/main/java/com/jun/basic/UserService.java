package com.jun.basic;

import com.jun.basic.User;

/**
 * @author HuangJun7
 * @date 2021-10-26 12:21
 */
public interface UserService {
    void register(User user);

    void login(String name, String password);
}
