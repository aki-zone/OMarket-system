package com.As.test.mybatis;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.dao.IItemDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTestItem {
    SqlSession sqlSession= MybatisUtils.getSqlSession();

    @Test
    public void byList() {
        try {
            IItemDAO mapper = sqlSession.getMapper(IItemDAO.class);
            List<Item> items = mapper.getItemList();
            System.out.println(items);
            System.out.println("-------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void byOId() {
        try {
            IItemDAO mapper = sqlSession.getMapper(IItemDAO.class);
            Item item = mapper.getByOId("1");
            System.out.println(item);
            System.out.println("-------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void byOO() {
        try {
            IItemDAO mapper = sqlSession.getMapper(IItemDAO.class);
            List<Item> items = mapper.getByOO("1");
            System.out.println(items);
            System.out.println("-------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    /*@Test
    public void putItem() {
        Account account = new Account("1","111111");
        Item item = new Item("King of 405","999999");
        long row = OPutItem.putByinfo(account,item);
        System.out.println(row);
        System.out.println("-------------------------------------------");
    }*/


}
