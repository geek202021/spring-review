package com.jun.transaction;

import com.jun.dao.UserDAO;
import com.jun.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HuangJun7
 * @date 2021-10-28 13:45
 */
@Transactional
public class UserServiceImpl implements UserService{
    //UserServiceImpl是原始对象，负责核心功能和DAO的调用
    //把UserDAO作为其成员变量，注入
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) {
        userDAO.save(user);
    }
}
