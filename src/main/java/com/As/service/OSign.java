package com.As.service;

import com.As.VO.User;
import com.As.dao.IUserDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class OSign {
    private static SqlSession sqlSession = MybatisUtils.getSqlSession();
    public static long sign(String username,
                           String phoneNum,
                           String password,
                           String balances) {
        IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
        User user = new User();
        user.setUsername(username);
        user.setPhoneNum(phoneNum);
        user.setPassword(password);
        user.setBalances(balances);
        user.setRegsTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        long x = mapper.insert(user);
        if(x>0){
            sqlSession.commit();
            sqlSession.close();
            return x;
            /*
               return the successful row
             */
        }else {
            sqlSession.close();
            /*
               return the failed row
             */
            return -401;
        }
    }
}
