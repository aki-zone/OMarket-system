package com.As.VO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Item {
    private String OId;
    private String name;
    private String description;
    private String price;
    private Integer num;
    private List<Category> categories = new ArrayList<>();
    private Map<String, Integer> ownerOIdNum;


    public Item(Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.num = item.getNum();
        this.OId = item.OId;
        this.ownerOIdNum = item.getOwnerOIdNum();
        this.description = item.getDescription();
        this.categories = item.getCategories();
    }

    public Item() {
        this.name = "";
        this.price = "";
        this.num = 0;
        this.OId = "";
        this.description = "";
    }

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
        this.num = 0;
        this.OId = "";
        this.description = "";
    }

    public Item(String name, String price,Integer num) {
        this.name = name;
        this.price = price;
        this.num = num;
        this.OId = "";
        this.description = "";
    }

    public Item(String OId,Integer num) {
        this.name = "";
        this.price = "";
        this.num = num;
        this.OId = OId;
        this.description = "";
    }


    public String getOId() {
        return OId;
    }

    public void setOId(String OId) {
        this.OId = OId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Map<String, Integer> getOwnerOIdNum() {
        return ownerOIdNum;
    }

    public void setOwnerOIdNum(Map<String, Integer> ownerOIdNum) {
        this.ownerOIdNum = ownerOIdNum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


    @Override
    public String toString() {
        return "Item{" +
                "\tOId='" + OId + '\'' +
                ", \n\tname='" + name + '\'' +
                ", \n\tdescription='" + description + '\'' +
                ", \n\tprice='" + price + '\'' +
                ", \n\tnum=" + num +
                ", \n\townerOIdnum='" + ownerOIdNum + '\'' +
                ", \n\tcategories=" + categories +
                '}'+"\n";
    }
}
