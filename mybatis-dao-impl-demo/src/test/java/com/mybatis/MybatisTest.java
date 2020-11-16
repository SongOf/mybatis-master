package com.mybatis;

import com.mybatis.dao.IUserDao;
import com.mybatis.dao.impl.UserDaoImpl;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂创建dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destroy() throws IOException {
        //4.释放资源
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
    public void testSaveUser(){
        User user=new User();
        user.setUsername("小红");
        user.setAddress("北京市海淀区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前"+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后"+user);
    }

    @Test
    public void testUpdateUser(){
        User user=new User();
        user.setId(56);
        user.setUsername("大明");
        user.setAddress("北京市海淀区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(56);
    }

    @Test
    public void testfindUserById(){
        User user=userDao.findUserById(41);
        System.out.println(user);
    }

    @Test
    public void testfindUserByName(){
        List<User> users=userDao.findUserByName("%王%");
        for(User user : users){
            System.out.println(user);
        }
    }
}
