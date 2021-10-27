package com.jun.jdk;

import com.jun.proxy.User;
import com.jun.proxy.UserService;
import com.jun.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author HuangJun7
 * @date 2021-10-27 13:35
 */
public class TestJDKProxy {
    public static void main(String[] args) {
        //1.创建原始对象
        UserService userService = new UserServiceImpl();
        /**
         * 2.JDK创建动态代理
         *      类加载器、原始对象所创建的接口、额外的功能
         *      借用一个类加载器
         */
        InvocationHandler handler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("--额外功能在原始方法之前运行--");
                //先让原始方法运行:动态代理中的为invocation.proceed();
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
        userServiceProxy.login("jun", "1234");
        userServiceProxy.register(new User());
    }
}
