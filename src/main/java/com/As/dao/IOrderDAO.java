package com.As.dao;

import com.As.VO.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrderDAO {
    List<Order> getOrderList();
    Order getByOId(@Param("OId") String OId);
    List<Order> getByStatus(@Param("status") String status);
    List<Order> getByBuyerId(@Param("buyerId") String buyerId);
    List<Order> getBySellerId(@Param("sellerId") String sellerId);
    List<Order> getByIO(@Param("IO") String IO);

    //List<Order> searchTime(@Param("front") String front,@Param("back") String back);

    long insert(@Param("order")Order order);
    long insertOrder(@Param("order")Order order);
    long update(@Param("order")Order order);
    long delete(@Param("OId") String OId);
    boolean isHaveId(@Param("OId") String OId);

    String getTotalNum();
    String getTotalValue();
}
