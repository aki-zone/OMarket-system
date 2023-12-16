package com.As.service;

import com.As.VO.*;
import com.As.dao.ICategoryDAO;
import com.As.dao.IItemDAO;
import com.As.dao.IOrderDAO;
import com.As.dao.IUserDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.formula.atp.Switch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OSercher {

    private static Integer OAuthority = 0;
    public static List<String> searchUser(Account account,String x){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            List<User> list = userDAO.getUserList();
            List<String> result = new ArrayList<>();
            for (User us: list) {
                if(us.getOId().contains(x)){
                    result.add(us.getOId());

                } else if (us.getBalances().contains(x)) {
                    result.add(us.getOId());

                }else if (us.getEmail().contains(x)){
                    result.add(us.getOId());

                }else if(us.getAddress().contains(x)){
                    result.add(us.getOId());

                }else if(us.getPhoneNum().contains(x)){
                    result.add(us.getOId());

                }else if(us.getUsername().contains(x)){
                    result.add(us.getOId());
                }
            }
            return result;
        }
    }

    public static List<String> searchOrder(Account account, String x) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            List<Order> list = orderDAO.getOrderList();
            List<String> result = new ArrayList<>();
            for (Order order : list) {
                if (order.getOId().contains(x)) {
                    result.add(order.getOId());
                } else if (order.getStatus().toString().contains(x)) {
                    result.add(order.getOId());
                } else if (order.getBuyerId().contains(x)) {
                    result.add(order.getOId());
                } else if (order.getSellerId().contains(x)) {
                    result.add(order.getOId());
                } else if (order.getItemsId().contains(x)) {
                    result.add(order.getOId());
                } else if (order.getTime().contains(x)) {
                    result.add(order.getOId());
                } else if (order.getNum().toString().contains(x)) {
                    result.add(order.getOId());
                } else if (order.getValue().contains(x)) {
                    result.add(order.getOId());
                }
            }
            return result;
        }
    }


    public static List<String> searchItem(Account account, String x) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            IItemDAO itemDAO = sqlSession.getMapper(IItemDAO.class);
            List<Item> list = itemDAO.getItemList();
            List<String> result = new ArrayList<>();
            for (Item item : list) {
                if (item.getOId().contains(x)) {
                    result.add(item.getOId());
                } else if (item.getName().contains(x)) {
                    result.add(item.getOId());
                } else if (item.getDescription().contains(x)) {
                    result.add(item.getOId());
                } else if (item.getPrice().contains(x)) {
                    result.add(item.getOId());
                } else if (item.getNum().toString().contains(x)) {
                    result.add(item.getOId());
                } else {
                    for (Category category : item.getCategories()) {
                        if (category.getName().contains(x)) {
                            result.add(item.getOId());
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }

    public static List<String> searchCate(Account account, String x) {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            List<Category> list = categoryDAO.getCateList();
            List<String> result = new ArrayList<>();
            for (Category category : list) {
                if (category.getOId().contains(x)) {
                    result.add(category.getOId());
                } else if (category.getName().contains(x)) {
                    result.add(category.getOId());
                }
            }
            return result;
        }
    }


    public static List<String> findItem(String x, List<Item> list){
        List<String> result = new ArrayList<>();
        for (Item it: list) {
            if(it.getOId().contains(x)){
                result.add(it.getOId());

            } else if (it.getName().contains(x)) {
                result.add(it.getOId());

            }else if (it.getDescription().contains(x)){
                result.add(it.getOId());
            }
        }
        return result;
    }



    /*  sub fuction */
    public static List<String> findSubString(String x, List<String> list) {
        List<String> result = new ArrayList<>();

        for (String str : list) {
            if (str.contains(x)) {
                result.add(str);
            }
        }
        return result;
    }

    public static Integer check(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            return mapper.getByOId(account.getOId()).getStatus();
        }
    }

    public static List<String> dataSearch(Account account,String table,String text){
        if (check(account) < OAuthority) {
            return null;
        }
        switch (table){
            case "item":return searchItem(account,text);
            case "user":return searchUser(account,text);
            case "order":return searchOrder(account,text);
            case "cate":return searchCate(account,text);
            default:return null;
        }

    }
}
