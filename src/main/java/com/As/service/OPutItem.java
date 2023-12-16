package com.As.service;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.VO.User;
import com.As.VO.User_Item;
import com.As.dao.IItemDAO;
import com.As.dao.IUserDAO;
import com.As.dao.IUser_ItemDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;


import java.util.List;
import java.util.Objects;

public class OPutItem {
    private static SqlSession sqlSession = MybatisUtils.getSqlSession();
    private static Integer OAuthority = 0;
    /**
     * Authority grade should be super than "OAuthority "
     */
    public static long putItem(Account account,Item item) {
        IUserDAO userMapper = sqlSession.getMapper(IUserDAO.class);
        IItemDAO itemMapper = sqlSession.getMapper(IItemDAO.class);
        IUser_ItemDAO user_itemMapper = sqlSession.getMapper(IUser_ItemDAO.class);


        User user = userMapper.getByOId(account.getOId());

        if(user.getStatus()<OAuthority){
            sqlSession.close();
            return -201;
        }

        if( Objects.equals(user.getPassword(), account.getPassword())
        && !Objects.equals(account.getOId(), "")
        && !Objects.equals(account.getPassword(), "")){


            List<Item> haveItems = user_itemMapper.getItemList(account.getOId());

            for (Item it : haveItems) {
                if (it.getOId().equals(item.getOId())) {

                    if (it.getNum()+item.getNum()<0){
                        sqlSession.close();
                        return -403;
                        /*
                            haven owned this item but not enough,so can't add "negative number"
                         */
                    }


                    long rowItem  = itemMapper.updateAdd(item.getOId(),item.getNum());
                    if(rowItem>0){
                        sqlSession.commit();
                    }else {
                        sqlSession.close();
                        return -1501;
                        /*
                          item row  update went wrong, return -1 + -501
                         */
                    }

                    long rowUi = user_itemMapper.updateAdd(account.getOId(),item.getOId(),item.getNum());
                    if(rowUi>0){
                        sqlSession.commit();
                    }else {
                        sqlSession.close();
                        return -1502;
                        /*
                            User_item row  update went wrong, return -1 + -502
                         */
                    }

                    return rowItem*rowUi;
                }
            }

            if (item.getNum()<0){
                return -402;
                /*
                    haven't owned this item yet ,so can't add "negative number"
                 */
            }

            long rowItem;

            List<String> itemOIds = OSercher.findItem(item.getOId(),itemMapper.getOIdList());

            if(itemOIds.contains(item.getOId())){
                rowItem = itemMapper.updateAdd(item.getOId(),item.getNum());
            }else{
                rowItem= itemMapper.insertItem(item);
            }

            if(rowItem>0){
                sqlSession.commit();
            }else {
                sqlSession.close();
                return -2501;
                /*
                  item row  insert went wrong, return -2 + -501
                 */
            }
            User_Item user_item = new User_Item(account.getOId(),item.getOId(),item.getNum());
            long rowUi = user_itemMapper.insert(user_item);
            if(rowUi>0){
                sqlSession.commit();
            }else {
                sqlSession.close();
                return -2502;
                /*
                  item row   insert went wrong, return -2 + -501
                 */
            }
            sqlSession.close();
            return rowItem*rowUi;
        }else {
            sqlSession.close();
            return -400;
        }
    }
}
