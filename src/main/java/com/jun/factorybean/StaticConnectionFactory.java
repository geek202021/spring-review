package com.jun.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 实例工厂：必须先要ConnectionFactory cf = new ConnectionFactory();
 *         再来调用：cf.getConnection();
 * 静态工厂：直接：staticConnectionFactory.getConnection();
 * @author HuangJun7
 * @date 2021-10-26 16:15
 */
public class StaticConnectionFactory {
    public static Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false","root","hrj");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }
}
