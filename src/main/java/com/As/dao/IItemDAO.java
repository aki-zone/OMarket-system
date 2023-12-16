package com.As.dao;

import com.As.VO.Item;
import com.As.VO.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IItemDAO {
    List<Item> getItemList();
    List<Item> getOIdList();
    List<Item> getNameList();
    List<Item> getTextList();

    Item getByOId(@Param("OId") String OId);
    List<Item> getByOO(@Param("ownerOId") String ownerOId);

    List<String> getIOByUO(@Param("ownerOId") String ownerOId);

    long insertItem(@Param("item")Item item);

    long insert(@Param("item")Item item);

    long update(@Param("item")Item item);
    long updateAdd(@Param("OId") String OId, @Param("addNum")int addNum);

    long updatePrice(@Param("OId") String OId, @Param("price")int price);

    long deleteByOId(@Param("OId") String OId);
    boolean isHaveId(@Param("OId") String OId);

    String getTotalNum();
    String getTotalValue();
}
