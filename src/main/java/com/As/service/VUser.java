package com.As.service;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.VO.User;
import com.As.dao.IItemDAO;
import com.As.dao.IUserDAO;
import com.As.dao.IUser_ItemDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Objects;

public class VUser {
    private static SqlSession sqlSession = MybatisUtils.getSqlSession();
    private static Integer OAuthority = 9;
    /**
     * Authority grade should be super than "OAuthority "
     */
    public static String getPsw(Account manager,String x_OId) {
        IUserDAO userMapper = sqlSession.getMapper(IUserDAO.class);
        User managerUser = userMapper.getByOP(manager.getOId(), manager.getPassword());


        if(managerUser.getStatus()<OAuthority){
            sqlSession.close();
            return "-201";
            /*
             manager's Authority grade can't get enough;
            */
        }


        if (!Objects.equals(managerUser.getOId(), "")
         && !Objects.equals(managerUser.getPassword(), "")){

            User x_user = userMapper.getByOId(x_OId);
            sqlSession.close();
            return x_user.getPassword();
            /*
                meet the Authority grade,return the psw which manager meets OId;
            */
        }else {
            sqlSession.close();
            return "-404";
            /*
                manager is null;
             */
        }
    }

    public static long clearUser(Account  manager,Account account){
        IUserDAO userMapper           = sqlSession.getMapper(IUserDAO.class);
        IItemDAO itemMapper           = sqlSession.getMapper(IItemDAO.class);
        IUser_ItemDAO user_itemMapper = sqlSession.getMapper(IUser_ItemDAO.class);
        User managerUser = userMapper.getByOP(manager.getOId(), manager.getPassword());
        User accountUser = userMapper.getByOId(account.getOId());


        if(managerUser.getStatus()<OAuthority){
            sqlSession.close();
            return -201;
            /*
             manager's Authority grade can't get enough;
            */
        }

        if(managerUser.getStatus()<=accountUser.getStatus()){
            sqlSession.close();
            return -202;
            /*
             manager's Authority grade should be super than account User;
            */
        }

        if (!Objects.equals(managerUser.getOId(), "")
          &&!Objects.equals(managerUser.getPassword(), "")
          &&!accountUser.getPassword().equals("")
          &&!accountUser.getOId().equals("")){

            List<Item> haveItems = user_itemMapper.getItemList(accountUser.getOId());
            long putRow = 1;
            long usrRow = 1;

            for (Item it:haveItems){
                it.setNum(-it.getNum());
                putRow *= OPutItem.putItem(account,it);
                if(putRow<0){
                    sqlSession.close();
                    return -1401;
                    /*
                      item clear put went wrong , return -1 + -401
                     */
                }
            }

            accountUser.setPhoneNum(null);
            accountUser.setBalances("0");
            accountUser.setStatus(-10);

            usrRow = userMapper.update(accountUser);
            if(usrRow>0){
                sqlSession.commit();
            }else {
                sqlSession.close();
                return -2401;
                /*
                  account clear put went wrong , return -2 + -401
                 */
            }

            return usrRow*putRow;
            /*
                meet the Authority grade,return the psw which manager meets OId;
                return products of rows , If it is a negative number, failure occurs
            */
        }else {
            sqlSession.close();
            return -404;
            /*
                manager or user is null;
             */
        }
    }
}
