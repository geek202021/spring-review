package com.jun.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 泛型表示：我们要创建什么样的复杂对象。
 * @author HuangJun7
 * @date 2021-10-26 14:44
 */
public class ConnectionFactoryBean implements FactoryBean<Connection> {
    // 将依赖的字符串信息变为成员变量, 利用配置文件进行注入。
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 用于书写创建复杂对象时的代码
    @Override
    public Connection getObject() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName(driverClassName);
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false", "root", "hrj");
        Connection connect = DriverManager.getConnection(url, username, password);
        return connect;
    }

    // 返回创建的复杂对象的类型
    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false; // 每一次都创建新的复杂对象
    }
}
