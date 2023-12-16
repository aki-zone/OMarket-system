package com.As.VO;

public class Category {
    private String OId;
    private String name;

    public Category(Category category) {
        this.OId = category.getOId();
        this.name = category.getName();
    }

    public Category() {
        this.OId = "";
        this.name = "";
    }

    public Category(String OId, String name) {
        this.OId = OId;
        this.name = name;
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

    @Override
    public String toString() {
        return "Category{" +
                "\n\tOId='" + OId + '\'' +
                ", \n\tname='" + name + '\'' +
                '}';
    }
}
