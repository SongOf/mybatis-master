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
 * @Date 2020/11/22 18:49
 * @Version 1.0
 */
public class SecondLevelCacheTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        //事务提交
        session.commit();
        //6.释放资源
        session.close();
        in.close();
    }

    @Test
    public void testFindById(){
        User user=userDao.findById(41);
        System.out.println(user);
        session.close();

        session=factory.openSession();
        userDao=session.getMapper(IUserDao.class);
        User user1=userDao.findById(41);
        System.out.println(user1);
        System.out.println(user==user1);
    }
}
