package com.As.util;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.VO.Order;
import com.As.VO.User;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatterns {

    private static int Ochoice;
    private static String Type = new String();
    private static String Text= new String();
    private static String[] parts = new String[50];
    private static Account account = new Account();
    private static Account buyerAccount = new Account();
    private static Account sellerAccount = new Account();
    private static Account otherAccount = new Account();
    private static Item item = new Item();
    private static Item newItem = new Item();
    private static User user = new User();
    private static User newUser = new User();
    private static Order order =new Order();
    private static Order newOrder =new Order();



    public String sign(String input){
        //String input = "-sign [\"lihua\"][\"17786525555\"][\"123456\"][\"50.98\"]";
        String loginRegex = "\\[|\\]|\\s+|,";
        String [] signTokens = input.split(loginRegex);
        TeseOut(signTokens);

        parts[1]=signTokens[1].replace("\"","");
        parts[2]=signTokens[3].replace("\"","");
        parts[3]=signTokens[5].replace("\"","");
        parts[4]=signTokens[7].replace("\"","");


        return "OK";
    }


    public String login(String input){
        //String input = "[\"2\"][account:[OId=\"1\",password=\"111111\"]]";

        String loginRegex = "\\[|\\]|\\s+|,|=";
        String[] loginTokens = input.split(loginRegex);

        //TeseOut(loginTokens);
        if(loginTokens[4].equals("phoneNum")){
            account.setPhoneNum(loginTokens[5].replace("\"", ""));
        }else {
            account.setOId(loginTokens[5].replace("\"", ""));
        }
        account.setPassword(loginTokens[7].replace("\"", ""));
        Ochoice =Integer.parseInt(loginTokens[1].replace("\"", ""));
        return "OK";
    }

    public String buy(String input){
        String buyRegex = "\\[|\\]|\\s+|,";
        String[] buyTokens = input.split(buyRegex);

        /*if (buyTokens.length != 14) {
            return "null"; // 格式不对，返回null
        }*/

        buyerAccount.setOId(buyTokens[2].split("=")[1].replace("\"", ""));
        buyerAccount.setPhoneNum(buyTokens[3].split("=")[1].replace("\"", ""));
        buyerAccount.setPassword(buyTokens[4].split("=")[1].replace("\"", ""));
        //System.out.println(buyerAccount);

        sellerAccount.setOId(buyTokens[8].split("=")[1].replace("\"", ""));
        sellerAccount.setPhoneNum(buyTokens[9].split("=")[1].replace("\"", ""));
        sellerAccount.setPassword(buyTokens[10].split("=")[1].replace("\"", ""));
        //System.out.println(sellerAccount);

        item.setOId(buyTokens[14].split("=")[1].replace("\"", ""));
        item.setName(buyTokens[15].split("=")[1].replace("\"", ""));
        item.setDescription(buyTokens[16].split("=")[1].replace("\"", ""));
        item.setPrice(buyTokens[17].split("=")[1].replace("\"", ""));
        item.setNum(Integer.parseInt(buyTokens[18].split("=")[1].replace("\"", "")));
        //System.out.println(item);
        return "OK";
    }


    public String clear(String input){
        String clearRegex = "\\[|\\]|\\s+|,";
        String[] clearTokens = input.split(clearRegex);

        account.setOId(clearTokens[2].split("=")[1].replace("\"", ""));
        account.setPhoneNum(clearTokens[3].split("=")[1].replace("\"", ""));
        account.setPassword(clearTokens[4].split("=")[1].replace("\"", ""));

        otherAccount.setOId(clearTokens[8].split("=")[1].replace("\"", ""));
        otherAccount.setPhoneNum(clearTokens[9].split("=")[1].replace("\"", ""));
        otherAccount.setPassword(clearTokens[10].split("=")[1].replace("\"", ""));

        return "OK";
    }

    public void TeseOut(String []TOKENS){
        int count = 0;
        for(String s:TOKENS){
            System.out.println(count+" #"+s+"#");
            count++;
        }
    }


    public String iout(String input){
        //String input ="[ManagerAccount:[OId=\"1\",phoneNum=\"\",password=\"123456\"]][Type=\"item\"]";
        String inRegex = "\\[|\\]|\\s+|,";
        String[] inTokens = input.split(inRegex);

        account.setOId(inTokens[2].split("=")[1].replace("\"", ""));
        account.setPhoneNum(inTokens[3].split("=")[1].replace("\"", ""));
        account.setPassword(inTokens[4].split("=")[1].replace("\"", ""));

        Type = (inTokens[7].split("=")[1].replace("\"", ""));

        return "OK";
    }

    public String ls(String input ) {
        String lsRegex = "\\[|\\]|\\s+|,";
        String[] lsTokens = input.split(lsRegex);

        account.setOId(lsTokens[2].split("=")[1].replace("\"", ""));
        account.setPhoneNum(lsTokens[3].split("=")[1].replace("\"", ""));
        account.setPassword(lsTokens[4].split("=")[1].replace("\"", ""));
        Type = lsTokens[7].split("=")[1].replace("\"", "");

        return "OK";
    }

    public String detail(String input ) {
        String lsRegex = "\\[|\\]|\\s+|,";
        String[] lsTokens = input.split(lsRegex);
        account.setOId(lsTokens[2].split("=")[1].replace("\"", ""));
        account.setPhoneNum(lsTokens[3].split("=")[1].replace("\"", ""));
        account.setPassword(lsTokens[4].split("=")[1].replace("\"", ""));
        return "OK";
    }


    public String search(String input) {
        String lsRegex = "\\[|\\]|\\s+|,";
        String[] lsTokens = input.split(lsRegex);


        account.setOId(lsTokens[2].split("=")[1].replace("\"", ""));
        account.setPhoneNum(lsTokens[3].split("=")[1].replace("\"", ""));
        account.setPassword(lsTokens[4].split("=")[1].replace("\"", ""));
        Type = lsTokens[7].split("=")[1].replace("\"", "");
        Text = lsTokens[9].split("=")[1].replace("\"", "");

        return "OK";
    }


    //@Test
    public String update( String input) {
        //String input ="-update [ManagerAccount:[OId=\"1\",phoneNum=\"\",password=\"111111\"]][OrderId=\"\"][newOrder:[OId=\"__x1__\",status=__x2__,buyerId=\"__x3__\",sellerId=\"__x4__\",itemsId=\"__x5__\",time=\"__x6__\",num=__x7__,value=\"__x8__\"]]\n";
        String updateRegex = "\\[|\\]|\\s+|,";
        String[] updateTokens = input.replace(" ","").split(updateRegex);

        Type = "";
        //TeseOut(updateTokens);

        account.setOId(updateTokens[2].split("=")[1].replace("\"", ""));
        account.setPhoneNum(updateTokens[3].split("=")[1].replace("\"", ""));
        account.setPassword(updateTokens[4].split("=")[1].replace("\"", ""));

            if(updateTokens[7].contains("Item")) {
                Type = "item";
                parts[1] = updateTokens[7].split("=")[1].replace("\"", "");

                newItem.setOId(updateTokens[10].split("=")[1].replace("\"", ""));
                newItem.setName(updateTokens[11].split("=")[1].replace("\"", ""));
                newItem.setDescription(updateTokens[12].split("=")[1].replace("\"", ""));
                newItem.setPrice(updateTokens[13].split("=")[1].replace("\"", ""));
                String temp = updateTokens[14].split("=")[1].replace("\"", "");
                if(temp.equals("")){
                    newItem.setNum(null);
                }else {
                    newItem.setNum(Integer.parseInt(temp));
                }

                return "OK";
            }

            else if (updateTokens[7].contains("Order")) {
                Type = "order";
                parts[1] = updateTokens[7].split("=")[1].replace("\"", "");

                newOrder.setOId(updateTokens[10].split("=")[1].replace("\"", ""));
                String temp1 = updateTokens[11].split("=")[1].replace("\"", "");
                if(temp1.equals("")){
                    newOrder.setStatus(null);
                }else {
                    newOrder.setStatus(Integer.parseInt(temp1));
                }
                newOrder.setBuyerId(updateTokens[12].split("=")[1].replace("\"", ""));
                newOrder.setSellerId(updateTokens[13].split("=")[1].replace("\"", ""));
                newOrder.setItemsId(updateTokens[14].split("=")[1].replace("\"", ""));
                newOrder.setTime(updateTokens[15].split("=")[1].replace("\"", ""));
                String temp2 = updateTokens[16].split("=")[1].replace("\"", "");
                if(temp2.equals("")){
                    newOrder.setNum(null);
                }else {
                    newOrder.setNum(Integer.parseInt(temp2));
                }
                newOrder.setValue(updateTokens[17].split("=")[1].replace("\"", ""));
                return "OK";
            }

            else if(updateTokens[7].contains("User")) {
                Type = "user";
                parts[1] = updateTokens[7].split("=")[1].replace("\"", "");

                newUser.setOId(updateTokens[10].split("=")[1].replace("\"", ""));
                String temp = updateTokens[11].split("=")[1].replace("\"", "");
                if(temp.equals("")){
                    newUser.setStatus(null);
                }else {
                    newUser.setStatus(Integer.parseInt(temp));
                }

                newUser.setUsername(updateTokens[12].split("=")[1].replace("\"", ""));
                newUser.setPassword(updateTokens[13].split("=")[1].replace("\"", ""));
                newUser.setPhoneNum(updateTokens[14].split("=")[1].replace("\"", ""));
                newUser.setEmail(updateTokens[15].split("=")[1].replace("\"", ""));
                newUser.setAddress(updateTokens[16].split("=")[1].replace("\"", ""));
                newUser.setRegsTime(updateTokens[17].split("=")[1].replace("\"", ""));
                newUser.setBalances(updateTokens[18].split("=")[1].replace("\"", ""));
                return "OK";
            }
            else {
                return "Null";
            }
        }




    /*
    SUB fuction
    */
    public static String extractParamValue(String params, String paramName) {
        String regex = paramName + "=\"(\\w+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(params);
        return matcher.find() ? matcher.group(1) : "";
    }

    public int getOchoice() {
        return Ochoice;
    }

    public void setOchoice(int ochoice) {
        Ochoice = ochoice;
    }

    public String[] getParts() {
        return parts;
    }

    public void setParts(String[] parts) {
        MyPatterns.parts = parts;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        MyPatterns.account = account;
    }

    public Account getBuyerAccount() {
        return buyerAccount;
    }

    public  void setBuyerAccount(Account buyerAccount) {
        MyPatterns.buyerAccount = buyerAccount;
    }

    public Account getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(Account sellerAccount) {
        MyPatterns.sellerAccount = sellerAccount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        MyPatterns.item = item;
    }

    public  Account getOtherAccount() {
        return otherAccount;
    }

    public void setOtherAccount(Account otherAccount) {
        MyPatterns.otherAccount = otherAccount;
    }

    public String getType() {
        return Type;
    }

    public  void setType(String type) {
        Type = type;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        MyPatterns.newItem = newItem;
    }

    public  User getUser() {
        return user;
    }

    public void setUser(User user) {
        MyPatterns.user = user;
    }

    public  User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        MyPatterns.newUser = newUser;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        MyPatterns.order = order;
    }

    public Order getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(Order newOrder) {
        MyPatterns.newOrder = newOrder;
    }

    public MyPatterns() {
    }
}
