package com.jun.proxy;

/**
 * ้ๆไปฃ็
 * @author HuangJun7
 * @date 2021-10-26 22:35
 */
public interface UserService {
    void register(User user);
    boolean login(String name, String password);
}
