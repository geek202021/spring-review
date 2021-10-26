package com.jun.life;

import org.springframework.beans.factory.InitializingBean;

/**
 * InitializingBean接口是Spring固定的接口，用它也耦合了Spring框架。
 *      第二种初始化方式：想要不耦合，只需要自己创建一个初始化方法，然后在配置文件中init-method引入。
 *      如果⼀个对象既实现 InitializingBean 同时又提供的 普通的初始化方法，执行顺序?
 *      答：先执行 InitializingBean，再执行 普通初始化方法。
 * @author HuangJun7
 * @date 2021-10-26 16:40
 */
//public class Product implements InitializingBean { //初始化方法一：Spring框架提供的接口
public class Product { //初始化方法二：对象中提供一个普通的方法
    public Product() {
        //scope为singleton时，表示工厂被创建时，无参构造就被调用了。
        //scope为prototype时，只有当ctx.getBean("product");获取时，才会调用无参构造
        System.out.println("Product无参构造被调用~");
    }

    //程序员根据需求实现初始化方法, 完成初始化操作。Spring会进行调用
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Spring调用Programmer创建的初始化方法完成初始化操作~");
//    }

    public void MyInit() {
        System.out.println("自定义的初始化方法MyInit被调用~");
    }
}
