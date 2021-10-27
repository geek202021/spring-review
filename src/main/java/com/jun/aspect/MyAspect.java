package com.jun.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 *  1. 额外功能
 *         public class MyAround implements MethodInterceptor {
 *             public Object invoke(MethodInvocation invocation) {
 *                 Object ret = invocation.invoke();
 *                 return ret;
 *             }
 *         }
 *         <bean id="around" class="com.yusael.dynamic.Around"/>
 *     2. 切入点
 *         <aop:config>
 *             <aop:pointcut id="pc" expression="execution(* login(..)))"/>
 *             <aop:advisor advice-ref="around" pointcut-ref="pc"/>
 *         </aop:config>
 * 基于AspectJ注解的AOP编程
 * @Apect 表示这个类是切面类
 * @author HuangJun7
 * @date 2021-10-27 15:27
 */
@Aspect //表示切面类
public class MyAspect {
//    @Pointcut("execution(* login(..))")
    @Pointcut("execution(* *..UserServiceImpl.*(..))")//指定 特定类作为切入点(额外功能加入的位置)，这个类中的所有方法，都会加上对应的额外功能。
    public void myPointcut(){}
    @Around(value="myPointcut()") //切入点
    //返回值Object代表原始方法的返回值，MethodInvocation invocation代表额外功能所增加给的那个原始方法
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=======aspectJ log=======");
        Object ret = joinPoint.proceed(); //它的返回值就是原始方法的返回值
        return ret;
    }
    @Around(value="myPointcut()") //切入点复用
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=======aspectJ tx=======");
        Object ret = joinPoint.proceed();
        return ret;
    }
}
