package com.As.VO;

public class Item_Category {
    private String itemsId;
    private String categoryId;

    public Item_Category() {
        this.itemsId    ="";
        this.categoryId ="";
    }

    public Item_Category(String itemsId, String categoryId,Integer num) {
        this.itemsId    = itemsId;
        this.categoryId = categoryId;
    }

    public String getItemsId() {
        return itemsId;
    }

    public void setItemsId(String itemsId) {
        this.itemsId = itemsId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Item_Category{" +
                "itemsId='" + itemsId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}
