package com.As.dao;

import com.As.VO.User;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IUserDAO {

    List<User> getUserList();
    List<User> getMailList();
    List<User> getOIdList();
    List<User> getNameList();
    List<User> getPhoneNumList();
    List<String> getOrderIdList(@Param("OId") String OId);
    List<String> getItemIdList(@Param("OId") String OId);

    String getTotalNum();
    String getTotalValue();

    User getByOId(@Param("OId") String OId);
    User getByPP(@Param("phone") String phone,@Param("password") String password);
    User getByOP(@Param("OId") String OId,@Param("password") String password);

    long insert(@Param("user") User user);
    long insertUser(@Param("user") User user);

    long update(@Param("user") User user);
    long userPay(@Param("OId") String OId,@Param("money") BigDecimal money);
    long delete(@Param("OId") String OId);
    boolean isHaveId(@Param("OId") String OId);
    boolean isHavePhone(@Param("phoneNum") String phoneNum);

}
