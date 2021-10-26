package com.jun.proxy;

/**
 * 静态代理-代理类就是为原始类添加额外功能
 * @author HuangJun7
 * @date 2021-10-26 22:40
 */
public class UserServiceProxy implements UserService{
    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    public void register(User user) {
        System.out.println("-----代理类的额外功能log-----");
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("-----代理类的额外功能log-----");
        return userService.login(name,password);
    }
}
