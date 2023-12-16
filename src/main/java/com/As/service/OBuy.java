package com.As.service;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.VO.Order;
import com.As.VO.User;
import com.As.dao.IItemDAO;
import com.As.dao.IOrderDAO;
import com.As.dao.IUserDAO;
import com.As.dao.IUser_ItemDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OBuy {
    private static SqlSession sqlSession = MybatisUtils.getSqlSession();
    private static Integer OAuthority = 0;
    /**
     * Authority grade should be super than "OAuthority "
     */

    public static Order buy(Account buyerAcount, Account sellerAcount, Item item){
        /*
            item used to get item's OId and num
            account used to get item's OId and psw
         */
        Order order = new Order();
        IUserDAO userMapper         = sqlSession.getMapper(IUserDAO.class);
        IOrderDAO orderMapper       = sqlSession.getMapper(IOrderDAO.class);
        IItemDAO itemMapper         = sqlSession.getMapper(IItemDAO.class);
        IUser_ItemDAO iUser_itemDAO = sqlSession.getMapper(IUser_ItemDAO.class);

        User buyer = userMapper.getByOP(buyerAcount.getOId(),buyerAcount.getPassword());
        User seller = userMapper.getByOP(sellerAcount.getOId(),sellerAcount.getPassword());

        if (buyer.getStatus()<OAuthority){
            order.setStatus(-1201);
            return order;
            /*
             buyer account's Authority grade can't get enough;
             return "-1 + -201"
            */
        }

        if (seller.getStatus()<OAuthority){
            order.setStatus(-2201);
            return order;
            /*
             seller account's Authority grade can't get enough;
             return "-2 + -201"
            */
        }

        /*
        System.out.println("“--------------------------------");
        System.out.println(buyer);
        System.out.println(seller);
        System.out.println(item);
        */
        List<Item> haveItems = iUser_itemDAO.getItemList(seller.getOId());

        boolean itEnough = false;
        boolean balEnough = false;
        BigDecimal itemPrice ;
        BigDecimal itemNum ;
        BigDecimal itemValue = new BigDecimal(0);


        for (Item it : haveItems){
            if (it.getOId().equals(item.getOId())){
                if(it.getNum()>item.getNum()){
                    itEnough = true;

                    itemPrice = new BigDecimal(itemMapper.getByOId(it.getOId()).getPrice());
                    itemNum = new BigDecimal(item.getNum());
                    itemValue = itemPrice.multiply(itemNum);

                    BigDecimal buyBalance = new BigDecimal(buyer.getBalances());

                    if(buyBalance.compareTo(itemPrice)>0){
                        balEnough = true;
                    }
                }

                break;
            }
        }


        if( itEnough&&balEnough ){
            order.setBuyerId(buyer.getOId());
            order.setSellerId(seller.getOId());
            order.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            order.setItemsId(item.getOId());
            order.setStatus(201);
            order.setNum(item.getNum());
            order.setValue(itemValue.toString());

            long orderRow = orderMapper.insert(order);

            if(orderRow>0){
                sqlSession.commit();
            }else{
                sqlSession.close();
                order.setStatus(-3401);
                return order;
                /*
                    order went wrong, return "-3 + -401"
                */
            }


            Item buyerItem =new Item(itemMapper.getByOId(item.getOId())) ;
            Item sellerItem = new Item(itemMapper.getByOId(item.getOId()));



            sellerItem.setNum(item.getNum()*-1);
            buyerItem.setNum(item.getNum());

            long sellerRow =OPutItem.putItem(sellerAcount,sellerItem);
            long buyerRow = OPutItem.putItem(buyerAcount,buyerItem);

            long sellerRow2 = userMapper.userPay(seller.getOId(),itemValue.negate());
            if (sellerRow2>0){
                sqlSession.commit();
            }else {
                sqlSession.close();
                order.setStatus(-5401);
                return order;
            }

            long buyerRow2 = userMapper.userPay(buyer.getOId(),itemValue);
            if (buyerRow2>0){
                sqlSession.commit();
            }else {
                sqlSession.close();
                order.setStatus(-5402);
                return order;
            }

            order.setStatus(  Integer.valueOf( (int) (orderRow*buyerRow*sellerRow*sellerRow2*buyerRow2) )  );
            return order;

        }else if(!itEnough){
            order.setStatus(-2404);
            sqlSession.close();
            return order;
            /*
                seller haven't such many items, return "-2 + -404"
             */
        }else {
            order.setStatus(-3404);
            sqlSession.close();
            return order;
            /*
                buyer haven't enough money, return "-3 + -404"
             */

        }
    }
}
