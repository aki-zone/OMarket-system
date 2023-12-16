package com.As.VO;

public class Order {
    private String OId;
    private Integer status;
    private String buyerId;
    private String sellerId;
    private String itemsId;
    private String time;
    private Integer num;
    private String value;


    public Order(Order order) {
        this.OId     =order.getOId();
        this.status  =order.getStatus();
        this.time    =order.getTime();
        this.itemsId =order.getItemsId();
        this.sellerId=order.getSellerId();
        this.buyerId =order.getBuyerId();
        this.num     =order.getNum();
        this.value   =order.getValue();
    }

    public Order() {
        this.OId     ="";
        this.status  =0;
        this.time    ="";
        this.itemsId ="";
        this.sellerId="";
        this.buyerId ="";
        this.num     =null;
        this.value   ="";
    }

    public String getOId() {
        return OId;
    }

    public void setOId(String OId) {
        this.OId = OId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getItemsId() {
        return itemsId;
    }

    public void setItemsId(String itemsId) {
        this.itemsId = itemsId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Order{" + "\n"+
                "\tOId='" + OId + '\'' +
                ", \n\tstatus=" + status +
                ", \n\tbuyerId='" + buyerId + '\'' +
                ", \n\tsellerId='" + sellerId + '\'' +
                ", \n\titemsId='" + itemsId + '\'' +
                ", \n\ttime='" + time + '\'' +
                ", \n\tnum='" + num + '\'' +
                ", \n\tvalue='" + value + '\'' +
                '}'+"\n";
    }
}
