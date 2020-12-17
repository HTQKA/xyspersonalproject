package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: xyspersonalproject
 * @description: User业务处理类
 * @author: 徐杨顺
 * @created: 2020/12/15 16:54
 */
@Service
public class UserService {

    @Autowired(required = false)
    MybatisUtil mybatisUtil;
    public User querryOne(int i) {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getJson(i);
        MybatisUtil.closeSqlSession(sqlSession);
        return user;

    }

    public boolean querryLogin(String name,String password) {
        System.out.println("姓名:"+ name);
        System.out.println("密码:"+ password);
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.querryLogin(name, password);
        MybatisUtil.closeSqlSession(sqlSession);
        if (user != null) {
            System.out.println(user);
            return true;
        } else {
            return false;
        }
    }
}

