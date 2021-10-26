package com.jun.basic;

import com.jun.basic.User;
import com.jun.basic.UserDAO;
import com.jun.basic.UserService;

/**
 * @author HuangJun7
 * @date 2021-10-26 12:19
 */
public class UserServiceImpl implements UserService {
//    private UserDAO userDAO = new UserDAOImpl();
//    private UserDAO userDAO = (UserDAO) BeanFactory.getBean("userDAO");

    /**
     * Set注入详解用户自定义类型
     */
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

    @Override
    public void login(String name, String password) {
        userDAO.queryUserByNameAndPassword(name, password);
    }
}
