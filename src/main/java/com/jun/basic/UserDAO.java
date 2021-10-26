package com.jun.basic;

import com.jun.basic.User;

/**
 * @author HuangJun7
 * @date 2021-10-26 12:22
 */
public interface UserDAO {
    void save(User user);
    void queryUserByNameAndPassword(String name, String password);
}
