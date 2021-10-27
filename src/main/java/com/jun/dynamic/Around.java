package com.jun.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * methodInterceptor（方法拦截器）接口：额外功能可以根据需要运行在原始方法执行 前、后、前后。
 * @author HuangJun7
 * @date 2021-10-27 9:20
 */
public class Around implements MethodInterceptor {
    /**
     * @param methodInvocation ：额外功能所增加给的那个原始方法 (login, register)
     * methodInvocation.proceed()：原始方法运行
     * @return 返回值：Object：原始方法的返回值 (没有就返回 null),
     *         如果额外功能加给了login方法的话，返回值就代表的是login方法的返回值。
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("~额外功能运行在原始方法之前~");
        Object ret = methodInvocation.proceed();
        return ret;
    }
}
