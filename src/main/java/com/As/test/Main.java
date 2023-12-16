package com.As.test;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.service.OPutItem;

public class Main {
    public static void main(String[] args) {

        Account account = new Account("1","111111");
        Item item = new Item("xx","5.5",-9);
        item.setOId("1");
        long x =  OPutItem.putItem(account,item);
        System.out.println("解说是"+x);
    }
}
