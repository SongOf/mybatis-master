package com.mybatis;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author SongOf
 * @ClassName SecondLevelCacheTest
 * @Description
 * @Date 2020/11/22 15:00
 * @Version 1.0
 */
public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }

    @After
    public void destroy() throws IOException {
        in.close();
    }

    //测试二级缓存
    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1=factory.openSession();
        IUserDao userDao1=sqlSession1.getMapper(IUserDao.class);
        User user1=userDao1.findUserById(41);
        System.out.println(user1);
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2=factory.openSession();
        IUserDao userDao2=sqlSession2.getMapper(IUserDao.class);
        User user2=userDao2.findUserById(41);
        System.out.println(user2);
        sqlSession2.close();
        //二级缓存存放的是数据，使用的时候才封装成对象返回 因此结果为false
        System.out.println(user1==user2);
    }
}
