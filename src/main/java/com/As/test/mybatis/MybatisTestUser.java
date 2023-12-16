package com.As.test.mybatis;

import com.As.VO.Account;
import com.As.VO.User;
import com.As.dao.IUserDAO;
import com.As.service.OLogin;
import com.As.service.OSign;
import com.As.service.VUser;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTestUser {

    SqlSession sqlSession= MybatisUtils.getSqlSession();
    @Test
    public void byList() {
        try {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
                System.out.println("-------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void byOId() {
        try {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            User user = mapper.getByOId("1");
            System.out.println(user);
            System.out.println("-------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void byPP() {
        try {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            User user = mapper.getByOP("40","222222");
            System.out.println(user);
            System.out.println("-------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void toUser() {
        try {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            User us = new User("s","s","s","2029-02-01","0");
            long row = mapper.insert(us);
            System.out.println("在"+row+"行");
            String generatedKey = us.getOId();
            System.out.println("插入成功，生成的主键值：" + generatedKey);
            System.out.println("-------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void makeUser() {
        try {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            User us = mapper.getByOId("3");
            us.setPassword("555555");
            long row = mapper.update(us);
            System.out.println("在"+row+"行");
            System.out.println("修改成功。");
            User newus = mapper.getByOId("3");
            System.out.println(newus);
            System.out.println("-------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void takeUser() {
        try {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            long row = mapper.delete("21");
            System.out.println("在"+row+"行");
            System.out.println("删除成功。");
            System.out.println("-------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void loginUser() {
        Account account =new Account("1","111111");
        int x = OLogin.login(0,account);
        System.out.println("状态码为"+x);
    }

    @Test
    public void signUser() {
        long x = OSign.sign("ss","ss","111111","50");
        System.out.println("行数为"+x);
    }

    @Test
    public void vuserPsw() {
        Account account = new Account("1","111111");
        String x = VUser.getPsw(account,"2");
        System.out.println(x);
    }

}
