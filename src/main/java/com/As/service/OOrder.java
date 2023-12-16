package com.As.service;

import com.As.VO.Account;
import com.As.VO.Order;
import com.As.dao.IOrderDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class OOrder {
    private static SqlSession sqlSession = MybatisUtils.getSqlSession();
    public static long ConfirmReceipt(Account account,String orderId){
        IOrderDAO orderMapper = sqlSession.getMapper(IOrderDAO.class);
        Order order = orderMapper.getByOId(orderId);

       
        if(order.getStatus()>=300){
            return -200;
            /*
                can't confirm it  twice
            */
        }else if(order.getStatus()<0){
            return -505;
            /*
                can't operator this order
             */
        }
        long orderRow = orderMapper.update(order);
        order.setStatus(301);
        if(orderRow>0){
            sqlSession.commit();
            sqlSession.close();
        }else {
            sqlSession.close();
            return -401;
            /*
                order update went wrong .
             */
        }
        return orderRow;
    }
}
