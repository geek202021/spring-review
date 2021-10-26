package com.jun.basic;

import com.jun.basic.User;
import com.jun.basic.UserDAO;

/**
 * @author HuangJun7
 * @date 2021-10-26 12:23
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void save(User user) {
        System.out.println(user);
    }

    @Override
    public void queryUserByNameAndPassword(String name, String password) {
        System.out.println(name + " = " + password);
    }
}
