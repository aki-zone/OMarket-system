package com.As.service;

import com.As.VO.*;
import com.As.dao.*;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class VGet {

    private static Integer OAuthority = 9;

    public static List<Item> getItemList(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            IItemDAO itemMapper = sqlSession.getMapper(IItemDAO.class);
            return itemMapper.getItemList();
        }
    }
    public static boolean ItemHaveId(Account account,String OId){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return false;
            }
            IItemDAO itemMapper = sqlSession.getMapper(IItemDAO.class);
            return itemMapper.isHaveId(OId);
        }
    }
    public static long ItemInsert(Account account,Item item){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return -404;
            }
            IItemDAO itemMapper = sqlSession.getMapper(IItemDAO.class);
            long row = itemMapper.insertItem(item);
            sqlSession.commit();
            return row;
        }
    }
    public static long ItemInsertNull(Account account,Item item){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return -404;
            }
            IItemDAO itemMapper = sqlSession.getMapper(IItemDAO.class);
            long row = itemMapper.insert(item);
            sqlSession.commit();
            return row;
        }
    }

    public static List<Category> getCateList(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            return categoryMapper.getCateList();
        }
    }
    public static boolean CateHaveId(Account account,String OId){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return false;
            }
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            return categoryMapper.isHaveId(OId);
        }
    }
    public static boolean CateHaveName(Account account,String name){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return false;
            }
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            return categoryMapper.isHaveName(name);
        }
    }
    public static long CateInsertNull(Account account,Category category){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return -404;
            }
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            long row = categoryMapper.insert(category);
            sqlSession.commit();
            return row;
        }
    }

    public static long CateInsert(Account account,Category category){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return -404;
            }
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            long row = categoryMapper.insertCate(category);
            sqlSession.commit();
            return row;
        }
    }



    public static List<Order> getOrderList(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            IOrderDAO orderMapper = sqlSession.getMapper(IOrderDAO.class);
            List<Order> result = orderMapper.getOrderList();
            sqlSession.commit();
            return result;
        }
    }
    public static boolean OrderHaveId(Account account,String OId){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return false;
            }
            IOrderDAO orderMapper = sqlSession.getMapper(IOrderDAO.class);
            boolean result = orderMapper.isHaveId(OId);
            sqlSession.commit();
            return result;
        }
    }
    public static long OrderInsert(Account account,Order order){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IOrderDAO orderMapper = sqlSession.getMapper(IOrderDAO.class);
            if (check(account) < OAuthority) {
                return -404;
            }
            long row = orderMapper.insertOrder(order);
            sqlSession.commit();
            return row;
        }
    }
    public static long OrderInsertNull(Account account,Order order){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IOrderDAO orderMapper = sqlSession.getMapper(IOrderDAO.class);
            if (check(account) < OAuthority) {
                return -404;
            }
            long row = orderMapper.insert(order);
            sqlSession.commit();
            return row;
        }
    }



    public static List<User> getUserList(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO userMapper = sqlSession.getMapper(IUserDAO.class);
            if (check(account) < OAuthority) {
                return null;
            }
            return userMapper.getUserList();
        }
    }
    public static User getUserByOId(Account account,String OId){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO userMapper = sqlSession.getMapper(IUserDAO.class);
            if (check(account) < OAuthority) {
                return null;
            }
            return userMapper.getByOId(OId);
        }
    }

    public static boolean UserHaveId(Account account,String OId){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO userMapper = sqlSession.getMapper(IUserDAO.class);
            if (check(account) < OAuthority) {
                return false;
            }
            return userMapper.isHaveId(OId);
        }
    }
    public static boolean UserHavePhone(Account account,String phone){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO userMapper = sqlSession.getMapper(IUserDAO.class);
            if (check(account) < OAuthority) {
                return false;
            }
            return userMapper.isHavePhone(phone);
        }
    }
    public static long UserInsert(Account account,User user){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO userMapper = sqlSession.getMapper(IUserDAO.class);
            if (check(account) < OAuthority) {
                return -404;
            }
            long row = userMapper.insertUser(user);
            sqlSession.commit();
            return row;
        }
    }
    public static long UserInsertNull(Account account,User user){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO userMapper = sqlSession.getMapper(IUserDAO.class);
            if (check(account) < OAuthority) {
                return -404;
            }
            long row = userMapper.insert(user);
            sqlSession.commit();
            return row;
        }
    }



    public static List<User_Item> getUIList(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUser_ItemDAO iUser_itemDAO = sqlSession.getMapper(IUser_ItemDAO.class);
            if (check(account) < OAuthority) {
                return null;
            }
            return iUser_itemDAO.getUIlist();
        }
    }
    public static boolean User_ItemHave(Account account,User_Item ui){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return false;
            }
            IUser_ItemDAO iUser_itemDAO = sqlSession.getMapper(IUser_ItemDAO.class);
            boolean result = iUser_itemDAO.isHave(ui);
            sqlSession.commit();
            return result;
        }
    }
    public static long User_ItemInsert(Account account,User_Item ui){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return -404;
            }
            IUser_ItemDAO iUser_itemDAO = sqlSession.getMapper(IUser_ItemDAO.class);
            long row = iUser_itemDAO.insert(ui);
            sqlSession.commit();
            return row;
        }
    }



    public static List<Item_Category> getICList(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            IItem_CateDAO iItem_cateDAO = sqlSession.getMapper(IItem_CateDAO.class);
            List<Item_Category> result = iItem_cateDAO.getICList();
            sqlSession.commit();
            return result;
        }
    }
    public static boolean Item_CateHave(Account account,Item_Category ic){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return false;
            }
            IItem_CateDAO iItem_cateDAO = sqlSession.getMapper(IItem_CateDAO.class);
            boolean result = iItem_cateDAO.isHave(ic);
            sqlSession.commit();
            return result;
        }
    }
    public static long Item_CateInsert(Account account,Item_Category ic){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return -404;
            }
            IItem_CateDAO iItem_cateDAO = sqlSession.getMapper(IItem_CateDAO.class);
            long row = iItem_cateDAO.insert(ic);
            sqlSession.commit();
            return row;
        }
    }

    public static Integer getOAuthority() {
        return OAuthority;
    }

    public static Integer check(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            return mapper.getByOId(account.getOId()).getStatus();
        }
    }

    public static List<String> detail(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return null;
            }
            List<String> result = new ArrayList<>();
            IItemDAO itemDAO = sqlSession.getMapper(IItemDAO.class);
            IOrderDAO iOrderDAO = sqlSession.getMapper(IOrderDAO.class);
            IUserDAO iUserDAO = sqlSession.getMapper(IUserDAO.class);
            result.add(itemDAO.getTotalNum()); result.add(iUserDAO.getTotalNum()); result.add(iOrderDAO.getTotalNum());
            result.add(itemDAO.getTotalValue()); result.add(iUserDAO.getTotalValue()); result.add(iOrderDAO.getTotalValue());
            sqlSession.commit();
            return result;
        }
    }

    public static Integer ls(Account account, String choice){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return -401;
            }
            IItemDAO itemDAO            = sqlSession.getMapper(IItemDAO.class);
            IOrderDAO iOrderDAO         = sqlSession.getMapper(IOrderDAO.class);
            IUserDAO iUserDAO           = sqlSession.getMapper(IUserDAO.class);
            ICategoryDAO iCategoryDAO   = sqlSession.getMapper(ICategoryDAO.class);
            IItem_CateDAO iItem_cateDAO = sqlSession.getMapper(IItem_CateDAO.class);
            IUser_ItemDAO iUser_itemDAO = sqlSession.getMapper(IUser_ItemDAO.class);
            switch (choice){
                case "item":
                    System.out.println(itemDAO.getItemList()); sqlSession.close();return -200;
                case "order" :
                    System.out.println(iOrderDAO.getOrderList()); sqlSession.close();return -200;
                case "user":
                    System.out.println(iUserDAO.getUserList()); sqlSession.close();return -200;
                case "cate":
                    System.out.println(iCategoryDAO.getCateList()); sqlSession.close();return -200;
                case "item-cate":
                    System.out.println(iItem_cateDAO.getICList()); sqlSession.close();return -200;
                case "user-item":
                    System.out.println(iUser_itemDAO.getUIlist()); sqlSession.close();return -200;
                default:
                    System.out.println("commmand not right .");
                    sqlSession.close();
                    return  -403;
            }
        }
    }

    public static Object getByOId(Account account, String choice,String OId){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            if (check(account) < OAuthority) {
                return -401;
            }
            IItemDAO itemDAO            = sqlSession.getMapper(IItemDAO.class);
            IOrderDAO iOrderDAO         = sqlSession.getMapper(IOrderDAO.class);
            IUserDAO iUserDAO           = sqlSession.getMapper(IUserDAO.class);
            ICategoryDAO iCategoryDAO   = sqlSession.getMapper(ICategoryDAO.class);
            switch (choice){
                case "item":
                    Item item = itemDAO.getByOId(OId);
                    sqlSession.close();
                    return item;
                case "order" :
                    Order order = iOrderDAO.getByOId(OId);
                    sqlSession.close();
                    return order;
                case "user":
                    User user = iUserDAO.getByOId(OId);
                    sqlSession.close();
                    return user;
                case "cate":
                    Category category = iCategoryDAO.getByOId(OId);
                    sqlSession.close();
                    return category;
                default:
                    System.out.println("commmand not right .");
                    sqlSession.close();
                    return  null;
            }
        }
    }
}
