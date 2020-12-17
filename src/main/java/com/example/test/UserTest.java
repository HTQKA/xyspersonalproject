package com.example.test;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: xyspersonalproject
 * @description: Mybatis测试
 * @author: 徐杨顺
 * @created: 2020/12/16 08:42
 */
public class UserTest {
    //mybatis不使用接口
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "config/mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(in) ;
    }
    @Test
    public void testGetId() throws Exception {
        String resource = "config/mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.example.mapper.UserMapper.getJson", 1);
        System.out.println(user);
        sqlSession.close();

    }
    //mybatis使用接口
    @Test
    public void testGetId1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getJson(1);
        System.out.println(user);
        sqlSession.close();

    }
}
