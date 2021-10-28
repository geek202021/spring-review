package com.jun.proxy;

/**
 * 静态代理-代理类就是为原始类添加额外功能
 * 【存在的问题】：
 *      1.静态类文件数量过多，不利于项目管理
 *      UserServiceImpl、UserServiceProxy
 *      OrderServiceImpl、OrderServiceProxy
 *      2.额外功能维护性差：在代理类中修改额外功能较为麻烦
 * @author HuangJun7
 * @date 2021-10-26 22:40
 */
public class UserServiceProxy implements UserService{// 实现原始类相同的接口
    private UserServiceImpl userService = new UserServiceImpl();// 代理类中必须有原始类
    @Override
    public void register(User user) {
        System.out.println("-----静态代理类的额外功能log-----");
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("-----静态代理类的额外功能log-----");
        return userService.login(name,password);
    }
}
