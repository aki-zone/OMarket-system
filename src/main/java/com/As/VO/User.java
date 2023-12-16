package com.As.VO;

import java.util.ArrayList;
import java.util.List;


public class User {


    private String OId;
    private Integer status;
    private String username;
    private String password;
    private String phoneNum;
    private String email;
    private String address;
    private String regsTime;
    private String balances;

    private List<Order> orders = new ArrayList<>();

    private List<Item> items = new ArrayList<>();

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phoneNum = user.getPhoneNum();
        this.regsTime = user.getRegsTime();
        this.balances = user.getBalances();
        this.address  = user.getAddress();
        this.email    = user.getEmail();
        this.status   = user.getStatus();
        this.OId      = user.getOId();
        this.orders   = user.getOrders();
        this.items    = user.getItems();
    }

    public User() {
        this.username = "";
        this.password = "";
        this.phoneNum = "";
        this.regsTime = "";
        this.balances = "";
        this.address  = "";
        this.email    = "";
        this.status   = 0;
        this.OId      = "";
    }

    public User(String username, String password, String phoneNum, String regsTime, String balances) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.regsTime = regsTime;
        this.balances = balances;
        this.address  = "";
        this.email    = "";
        this.status   = 0;
        this.OId      = "";
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegsTime() {
        return regsTime;
    }

    public void setRegsTime(String regsTime) {
        this.regsTime = regsTime;
    }

    public String getBalances() {
        return balances;
    }

    public void setBalances(String balances) {
        this.balances = balances;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "User{" + "\n"+
                "OId='" + OId + '\'' +
                ", \nstatus=" + status +
                ", \nusername='" + username + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nphoneNum='" + phoneNum + '\'' +
                ", \nemail='" + email + '\'' +
                ", \naddress='" + address + '\'' +
                ", \nregsTime='" + regsTime + '\'' +
                ", \nbalances='" + balances + '\'' +
                ", \norders:\n" + orders +
                ", \nitems=" + items +
                '}';
    }
}
