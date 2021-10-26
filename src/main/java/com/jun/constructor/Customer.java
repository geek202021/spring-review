package com.jun.constructor;

import java.io.Serializable;

/**
 * 构造注入
 * @author HuangJun7
 * @date 2021-10-26 14:08
 */
public class Customer implements Serializable {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
