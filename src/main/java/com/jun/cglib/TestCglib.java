package com.jun.cglib;

import com.jun.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author HuangJun7
 * @date 2021-10-27 13:54
 */
public class TestCglib {
    public static void main(String[] args) {
        //1.创建原始对象
        UserService userService = new UserService();
        /**
         * 2.通过cglib方式创建动态代理对象
         * 对比 jdk 动态代理 ---> Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
         *      Enhancer.setClassLoader()
         *      Enhancer.setSuperClass()  == interfaces
         *      Enhancer.setCallBack()设置额外功能 ---> MethodInterceptor(cglib包中的)
         *      Enhancer.create() ---> 创建代理对象
         */
        //Enhancer：通过继承父类创建的代理类
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());
        MethodInterceptor interceptor = new MethodInterceptor() {
            //等同于JDK动态代理中的 InvocationHandler中的invoke方法
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("--cglib动态代理--");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };
        //设置额外功能
        enhancer.setCallback(interceptor);
        //创建代理对象
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("jun", "1234");
        userServiceProxy.register(new User());
    }
}
