package com.As.dao;

import com.As.VO.Category;
import com.As.VO.Item;
import com.As.VO.Item_Category;
import com.As.VO.User_Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IItem_CateDAO {

    List<Item_Category> getICList();
    List<String> getCateId(@Param("itemsId") String itemsId);
    /**
     * return categotyId colomn base on itemId value
     */
    List<String> getItemId(@Param("categoryId") String categoryId);
    /**
     * return itemId colomn base on categoryId value
     */
    long insert(@Param("ic") Item_Category ic);

    boolean isHave(@Param("ic") Item_Category ic);
    /**
     * insert itemId-categoryId and return INSERT row information
     */
    long delete(@Param("itemsId") String itemsId,@Param("categoryId") String categoryId);
    /*
    *delete itemId-categoryId and return INSERT row information
    * */
}
