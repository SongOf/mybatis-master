package com.mybatis;

import com.mybatis.dao.IRoleDao;
import com.mybatis.domain.Role;
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
 * @ClassName RoleTest
 * @Description
 * @Date 2020/11/21 22:07
 * @Version 1.0
 */
public class RoleTest {
    private InputStream in;
    private SqlSession session;
    private IRoleDao roleDao;

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
        roleDao = session.getMapper(IRoleDao.class);
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
        List<Role> roles = roleDao.findAll();
        for(Role role : roles){
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
