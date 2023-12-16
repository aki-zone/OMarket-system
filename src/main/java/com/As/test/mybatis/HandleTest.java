package com.As.test.mybatis;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.VO.Order;
import com.As.service.OBuy;
import com.As.service.OPutItem;
import com.As.service.VUser;
import org.junit.Test;

public class HandleTest {

    public static Account manager = new Account("1","111111");
    @Test
    public void Oput(){
        Account account = new Account("3","123456");
        Item item = new Item("jjss","3.1",5);
        long x =  OPutItem.putItem(account,item);
        System.out.println("解说是"+x);
    }

    @Test
    public void Obuys(){
        Item item = new Item("1",15);
        Account buyer = new Account("2","123558");
        Account seller = new Account("1","111111");
        Order order = OBuy.buy(seller,buyer,item);
        System.out.println("asdasd*******************************"+order);
    }

    @Test
    public void OclearU(){
        Account buyer = new Account("2","123558");
        long row = VUser.clearUser(manager,buyer);
        System.out.println("****************************"+row+"#");
    }


}
