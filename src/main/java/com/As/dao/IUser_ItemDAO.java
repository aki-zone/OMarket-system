package com.As.dao;

import com.As.VO.Item;
import com.As.VO.User_Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUser_ItemDAO {

    List<User_Item> getUIlist();
    List<String> getUOlist(@Param("itemsId") String itemsId);

    List<Item> getItemList(@Param("userId") String userId);

    long insert(@Param("ui") User_Item ui);
    boolean isHave(@Param("ui") User_Item ui);
    long updateAdd(@Param("userId") String userId,@Param("itemsId") String itemsId,@Param("num") Integer num);

    long delete(@Param("userId") String userId,@Param("itemsId") String itemsId);

}
