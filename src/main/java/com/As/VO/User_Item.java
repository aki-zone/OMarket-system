package com.As.VO;

public class User_Item {
    private String userId;
    private String itemsId;

    private Integer num;

    public User_Item() {
        this.itemsId ="";
        this.userId ="";
        this.num    =0;
    }

    public User_Item(String userId, String itemId, Integer num) {
        this.userId = userId;
        this.itemsId = itemId;
        this.num = num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemsId() {
        return itemsId;
    }

    public void setItemId(String itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "User_Item{" +
                "userId='" + userId + '\'' +
                ", itemId='" + itemsId + '\'' +
                ", num=" + num +
                '}';
    }
}
