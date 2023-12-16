package com.As.dao;

import com.As.VO.Category;
import com.As.VO.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICategoryDAO {

    List<Category> getCateList();
    Category getByOId(@Param("OId") String OId);
    Category getByName(@Param("name") String name);
    List<Category> searchByName(@Param("name") String name);

    long insert(@Param("category")Category category);
    long insertCate(@Param("category")Category category);
    long upDateByOId(@Param("category")Category category);
    long deleteByOId(@Param("OId") String OId);
    boolean isHaveId(@Param("OId") String OId);
    boolean isHaveName(@Param("name") String name);

}
