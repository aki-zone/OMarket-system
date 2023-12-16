package com.As.VO;

public class Account {
    private String OId;
    private String password;
    private String phoneNum;

    public Account(Account account) {
        this.OId = account.getOId();
        this.password = account.getPassword();
        this.phoneNum = account.getPhoneNum();
    }
    public Account() {
        this.OId = "";
        this.password = "";
        this.phoneNum = "";
    }

    public Account(String OId, String password) {
        this.OId = OId;
        this.password = password;
        this.phoneNum = "";
    }

    public Account(String OId, String password, String phoneNum) {
        this.OId = OId;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    public String getOId() {
        return OId;
    }

    public void setOId(String OId) {
        this.OId = OId;
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

    @Override
    public String toString() {
        return "Account{" +
                "OId='" + OId + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
