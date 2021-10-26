package com.jun.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 实例工厂
 *      1.避免Spring框架的侵入
 *      2.整合遗留系统：有的公司已经把类(ConnectionFactory)和方法(getConnection)写好了
 *          我们只需要解决配置文件
 * @author HuangJun7
 * @date 2021-10-26 15:49
 */
public class ConnectionFactory {
    public Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false", "root", "hrj");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }
}
