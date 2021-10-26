package com.jun.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author HuangJun7
 * @date 2021-10-26 21:33
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //BeanPostProcessor 会对 Spring 工厂创建的所有对象进行加工。
        // 如果工厂创建了多个不同的对象，要注意区别传入的对象：
        if (bean instanceof Category) {
            Category category = (Category) bean;
            category.setName("hrj");
            return category;
        }
        return bean;
    }
}
