package com.jun;

import com.jun.basic.Person;
import com.jun.basic.User;
import com.jun.basic.UserService;
import com.jun.beanpost.Category;
import com.jun.constructor.Customer;
import com.jun.converter.Person2;
import com.jun.life.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author HuangJun7
 * @date 2021-10-26 9:04
 */
public class TestSpring {
    /**
     * 用于测试Spring的第一个程序
     */
    @Test
    public void test3() {
        //1.获得Spring的工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");//非web环境的工厂
        //2.通过工厂类获得对象
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }
    /**
     * 用于测试Spring工厂提供的其他方法
     *      xx.getBean(String s,Class aClass) 省去了强转的操作
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //1.提供id和class，此种方式不需要强制类型转换。
        Person person = ctx.getBean("person",Person.class);
        System.out.println("person="+person);
        //2.用此种方式，必须要求配置文件中只能有一个<bean class是Person类型
        Person person2 = ctx.getBean(Person.class);
        System.out.println("person=" + person2);
        //3.获取的是Spring工厂配置文件中所有bean标签的id值：
        String[] bdns = ctx.getBeanDefinitionNames();
        for (String bdn : bdns) {
            System.out.println("beanDefinitionName = " + bdn);
        }
        //4.根据类型获取配置文件中的id值
        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String id : beanNamesForType) {
            System.out.println("id = " + id);
        }
        //5.用于判断是否存在指定id值的bean
        if (ctx.containsBeanDefinition("person")) { //if(ctx.containBean("person"))
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    /**
     * 调用set方法为成员变量赋值。有强耦合
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        person.setId(1);
        person.setName("jun");
        System.out.println("person = " + person);
    }
    /**
     * 通过Spring工厂及配置文件，为所创建的对象的成员变量赋值
     *      1.提供get、set方法
     *      2.配置Spring的配置文件
     * Spring 底层通过调用对象属性对应的 set 方法，完成成员变量的赋值，这种方式也称为 Set注入。
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println("person = " + person);
    }
    /**
     * JDK类型成员变量的赋值
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        String[] emails = person.getEmails();
        for (String email : emails) {
            System.out.println("email = " + email);
        }
        System.out.println("------------------");
        Set<String> tels = person.getTels();
        for (String tel : tels) {
            System.out.println("tel = " + tel);
        }
        System.out.println("------------------");
        Map<String,String> qqs = person.getQqs();
        Set<String> keys = qqs.keySet();
        for (String key : keys) {
            System.out.println("key = " + key + " ,value is " + qqs.get(key));
        }
        System.out.println("------------------");
        Properties p = person.getP();
        System.out.println("key is key1" + " values is " + p.getProperty("key1"));
        System.out.println("key is key2" + " values is " + p.getProperty("key2"));
    }

    /**
     * 用于测试用户自定义类型的成员变量的赋值
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register(new User("jun","12345"));
        userService.login("jun","8888");
    }
    /**
     * 用于测试构造注入
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
    }

    /**
     * 用于测试FactoryBean接口
     */
    @Test
    public void test10() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection connect = (Connection) ctx.getBean("connect");
        System.out.println("connect = " + connect);
    }

    /**
     * 用于测试实例工厂
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }

    /**
     * 用于测试静态工厂
     */
    @Test
    public void test12() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("staticFactory");
        System.out.println("conn = " + conn);
    }

    /**
     * 用于测试生命周期
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //Product product = ctx.getBean("product", Product.class);
    }

    /**
     * 用于测试配置文件参数化
     */
    @Test
    public void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        Connection connect = (Connection) ctx.getBean("connect");
        System.out.println("connect = " + connect);
    }

    /**
     * 用于测试自定义类型转换器
     */
    @Test
    public void test15() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        Person2 person2 = ctx.getBean("person2", Person2.class);
        System.out.println("birthday = " + person2.getBirthday());
    }

    /**
     * 用于测试BeanPostProcessor
     */
    @Test
    public void test16() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext3.xml");
        Category c = (Category) ctx.getBean("c");
        System.out.println("name = " + c.getName());
    }
}
