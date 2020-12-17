package com.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: xyspersonalproject
 * @description: Mybatis工具类
 * @author: 徐杨顺
 * @created: 2020/12/16 09:36
 */
public class MybatisUtil {

    //获取SQLSessionFactory对象
    public static SqlSessionFactory getSqlSessionFactory() {

        InputStream in = null;
        try {
            String resource = "config/mybatis-config.xml";
            in = Resources.getResourceAsStream(resource);
            return new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //    关闭资源流
    public static void closeSqlSession(SqlSession sqlSession) {

        sqlSession.close();

    }
}
