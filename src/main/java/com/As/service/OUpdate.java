package com.As.service;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.VO.Order;
import com.As.VO.User;
import com.As.dao.IItemDAO;
import com.As.dao.IOrderDAO;
import com.As.dao.IUserDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;


public class OUpdate {

    private static Integer OAuthority = 0;
    private static Integer SuperAuthority = 9;

    public static Integer user(Account account,String oldUser, User newUser){
        if(check(account)<OAuthority){
            return -401;
        }
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
        if(!userDAO.isHaveId(oldUser)){
            return -404;
        }

        if (check(account)<SuperAuthority){
            if(!account.getOId().equals(oldUser)){
                return -403;
            }
        }

        User temp = userDAO.getByOId(oldUser);

        if(!isNull(newUser.getStatus())&&check(account)>=SuperAuthority){
            temp.setStatus(newUser.getStatus());
        }
        if (!isNull(newUser.getUsername())){
            temp.setUsername(newUser.getUsername());
        }
        if (!isNull(newUser.getPassword())) {
            temp.setPassword(newUser.getPassword());
        }
        if (!isNull(newUser.getPhoneNum()) && check(account) >= SuperAuthority) {
            temp.setPhoneNum(newUser.getPhoneNum());
        }
        if (!isNull(newUser.getEmail())) {
            temp.setEmail(newUser.getEmail());
        }
        if (!isNull(newUser.getAddress())) {
            temp.setAddress(newUser.getAddress());
        }
        if (!isNull(newUser.getRegsTime()) && check(account) >= SuperAuthority) {
            temp.setRegsTime(newUser.getRegsTime());
        }
        if (!isNull(newUser.getBalances()) && check(account) >= SuperAuthority) {
            temp.setBalances(newUser.getBalances());
        }
        //System.out.println(temp);
        // 更新用户信息
        userDAO.update(temp);
        sqlSession.commit();
        sqlSession.close();

        return -200;
    }

    public static Integer order(Account account, String oldOrder, Order newOrder) {
        if (check(account) < OAuthority) {
            System.out.println("+");
            return -401;
        }

        //System.out.println(newOrder);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
        IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);

        if (!orderDAO.isHaveId(oldOrder)) {
            return -404;
        }

        List<Order> isOwnedlist = orderDAO.getOrderList();
        if (check(account) < SuperAuthority) {
            int isowned = 0;
            for(Order or:isOwnedlist){
                if (or.getBuyerId().equals(account.getOId())||or.getItemsId().equals(account.getOId())){
                    isowned = 1;
                    break;
                }
            }
            if(isowned ==0){
                return -403;
            }
        }

        List<String> orderList = userDAO.getOrderIdList(account.getOId());
        if(orderList.contains(newOrder.getOId())&& check(account) < SuperAuthority){
            return -401;
        }

        Order temp = orderDAO.getByOId(oldOrder);

        if (!isNull(newOrder.getStatus())) {
            System.out.println("+");
            if(check(account) < SuperAuthority)
            {
                if(temp.getStatus()>newOrder.getStatus()) {
                    temp.setStatus(newOrder.getStatus());
                }
            }else {
                temp.setStatus(newOrder.getStatus());
            }

        }
        if (!isNull(newOrder.getBuyerId()) && check(account) >= SuperAuthority) {
            temp.setBuyerId(newOrder.getBuyerId());
        }
        if (!isNull(newOrder.getSellerId()) && check(account) >= SuperAuthority) {
            temp.setSellerId(newOrder.getSellerId());
        }
        if (!isNull(newOrder.getItemsId()) && check(account) >= SuperAuthority) {
            temp.setItemsId(newOrder.getItemsId());
        }
        if (!isNull(newOrder.getTime()) && check(account) >= SuperAuthority) {
            temp.setTime(newOrder.getTime());
        }
        if (!isNull(newOrder.getNum()) && check(account) >= SuperAuthority) {
            temp.setNum(newOrder.getNum());
        }
        if (!isNull(newOrder.getValue()) && check(account) >= SuperAuthority) {
            temp.setValue(newOrder.getValue());
        }

        // 更新订单信息
        orderDAO.update(temp);
        sqlSession.commit();
        sqlSession.close();

        return -200;
    }

    public static Integer item(Account account, String oldItem, Item newItem) {
        if (check(account) < OAuthority) {
            return -401;
        }

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        IItemDAO itemDAO = sqlSession.getMapper(IItemDAO.class);
        IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);

        if (!itemDAO.isHaveId(oldItem)) {
            return -404;
        }

        List<String> itemList = userDAO.getItemIdList(account.getOId());
        if(itemList.contains(newItem.getOId())&& check(account) < SuperAuthority){
            return -401;
        }

        Item temp = itemDAO.getByOId(oldItem);

        if (!isNull(newItem.getName())) {
            temp.setName(newItem.getName());
        }
        if (!isNull(newItem.getDescription())) {
            temp.setDescription(newItem.getDescription());
        }
        if (!isNull(newItem.getPrice())) {
            temp.setPrice(newItem.getPrice());
        }
        if (!isNull(newItem.getNum())) {
            temp.setNum(newItem.getNum());
        }

        // 更新物品信息
        itemDAO.update(temp);
        sqlSession.commit();
        sqlSession.close();

        return -200;
    }




    /* sub function */



    public static Integer update(Account account,String Type,String oldObject,Object newObject){
        if (check(account) < OAuthority) {
            return -403;
        }
        switch (Type){
            case "item":
                return item(account, oldObject, (Item) newObject);
            case "user":
                return user(account, oldObject, (User) newObject);
            case "order":
                return order(account, oldObject, (Order) newObject);
            default:return  -401;
        }
    }

    public static Integer check(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            return mapper.getByOId(account.getOId()).getStatus();
        }
    }
    public static boolean isNull(String x){
        return x.replace(" ","").isEmpty();
    }
    public static boolean isNull(Integer x){
        return x==null;
    }
}
