package com.As.service;

import com.As.VO.Account;
import com.As.VO.User;
import com.As.dao.IUserDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Objects;

public class OLogin {



    public static int login(int choice, Account account){
        try{
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            if(choice == 1){
                //login by phoneNum
                User user1 = mapper.getByPP(account.getPhoneNum(),account.getPassword());
                if(user1==null){
                    //sqlSession.close();
                    return -4041;
                    //no such account return "-404 + choice"
                }

                if (!Objects.equals(user1.getOId(), "")
                        && Objects.equals(user1.getPhoneNum(), account.getPhoneNum())
                        && Objects.equals(user1.getPassword(), account.getPassword())){
                    //sqlSession.close();
                    return -2001;
                    //account is not null, so accept it  and return  "-200 + choice"
                }else{
                    return -4041;
                    //account is null, so that DATA not found
                }
            } else if (choice == 2) {
                //System.out.println(account);
                User user2 = mapper.getByOP(account.getOId(),account.getPassword());
                if(user2==null){
                    //sqlSession.close();

                    return -4040;
                    //no such account return "-404 + choice"
                }
                if (!Objects.equals(user2.getPassword(), "")
                        && Objects.equals(user2.getOId(), account.getOId())
                        && Objects.equals(user2.getPassword(), account.getPassword())){
                    //sqlSession.close();
                    return -2000;
                    //account is not null, so accept it  and return  "-200 + choice"
                }else{
                    //sqlSession.close();
                    return -4043;
                    //account is null, so that DATA not found
                }
            }else {
                //sqlSession.close();
                return -4004;
                //choice is wrong; return -400 + 4
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
