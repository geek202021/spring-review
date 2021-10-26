package com.jun.basic;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author HuangJun7
 * @date 2021-10-26 8:59
 */
//new Person() 通过工厂
public class Person {
    private Integer id;
    private String name;
    private String[] emails;
    private Set<String> tels;
    private Map<String,String> qqs;
    private Properties p;
    //反射创建对象，底层也是会调用对象自己的构造方法。
    //Spring工厂也是可以调用对象私有的构造方法创建对象的。
    public Person() {
        System.out.println("Person.Person");
    }

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public Set<String> getTels() {
        return tels;
    }

    public void setTels(Set<String> tels) {
        this.tels = tels;
    }

    public Map<String, String> getQqs() {
        return qqs;
    }

    public void setQqs(Map<String, String> qqs) {
        this.qqs = qqs;
    }
}
