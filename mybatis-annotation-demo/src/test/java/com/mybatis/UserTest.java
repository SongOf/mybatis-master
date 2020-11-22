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

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
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
        List<User> users=userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindById(){
        User user=userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName(){
        List<User> users=userDao.findUserByName("%王%");
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser(){
        User user=new User();
        user.setUsername("李小二");
        user.setAddress("海淀区");
        user.setSex("男");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdateUser(){
        User user=new User();
        user.setId(57);
        user.setUsername("李小二");
        user.setAddress("海淀区");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(57);
    }
}
