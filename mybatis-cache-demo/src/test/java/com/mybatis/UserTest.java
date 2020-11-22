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

public class UserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

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
    public void testFindAll(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testfindUserById(){
        User user=userDao.findUserById(41);
        System.out.println(user);
    }

    //测试使用了一级缓存
    @Test
    public void testFirstLevelCache(){
        User user1=userDao.findUserById(41);
        System.out.println(user1);
        User user2=userDao.findUserById(41);
        System.out.println(user2);
        System.out.println(user1==user2);
    }
    //测试使用了一级缓存
    @Test
    public void testFirstLevelCache1(){
        User user1=userDao.findUserById(41);
        System.out.println(user1);
//        session.close();
//
//        session=factory.openSession();
        session.clearCache();
//        userDao=session.getMapper(IUserDao.class);
        User user2=userDao.findUserById(41);
        System.out.println(user2);
        System.out.println(user1==user2);
    }
    /***
    * @Description 测试缓存的同步
    * @Param
    * @return
    */
    @Test
    public void testClearCache1(){
        //   1.查询用户
        User user1=userDao.findUserById(41);
        System.out.println(user1);
        //   2.更新用户
        user1.setUsername("updateAfter");
        user1.setAddress("海淀区");
        userDao.updateUser(user1);
        //   3.再次查询用户
        User user2=userDao.findUserById(41);
        System.out.println(user2);
        System.out.println(user1==user2);
    }
}
