package com.jun.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author HuangJun7
 * @date 2021-10-27 17:45
 */
public class TestMyBatis {
    public static void main(String[] args) throws IOException {
        InputStream ins = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);
        SqlSession session = sqlSessionFactory.openSession();
        UserDAO userDAO = session.getMapper(UserDAO.class);
        User user = new User();
        user.setName("jun");
        user.setPassword("1324");
        userDAO.save(user);
        //提交事务
        session.commit();
    }
}
