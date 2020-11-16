package com.mybatis.dao.impl;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }
    public List<User> findAll() {
        SqlSession session=factory.openSession();
        List<User> users=session.selectList("com.mybatis.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session=factory.openSession();
        session.insert("com.mybatis.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session=factory.openSession();
        session.update("com.mybatis.dao.IUserDao.updateUser",user);
        session.commit();
        session.close();
    }

    public void deleteUser(Integer userId) {
        SqlSession session=factory.openSession();
        session.delete("com.mybatis.dao.IUserDao.deleteUser",userId);
        session.commit();
        session.close();
    }

    public User findUserById(Integer userId) {
        SqlSession session=factory.openSession();
        User user=session.selectOne("com.mybatis.dao.IUserDao.findUserById",userId);
        session.close();
        return user;
    }

    public List<User> findUserByName(String username) {
        SqlSession session=factory.openSession();
        List<User> users=session.selectList("com.mybatis.dao.IUserDao.findUserByName",username);
        session.close();
        return users;
    }
}
