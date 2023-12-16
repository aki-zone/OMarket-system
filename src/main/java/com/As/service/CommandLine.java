package com.As.service;

import com.As.VO.Account;
import com.As.VO.Help;
import com.As.VO.Order;
import com.As.util.MyPatterns;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandLine {

    public static List<String> StringListTemp = new ArrayList<>();
    private static String[] StringArrayTemp = new String[50];
    private static Account[] AccountArrayTemp = new Account[10];
    private static Account myAccount = new Account();



    public static String watchInPut(String input){
        int dashIndex = input.indexOf("-");
        int spaceIndex = input.indexOf(" ", dashIndex);

        if (input.trim().equals("-x")) {
            return "-x";
        }else if(input.trim().equals("-bye")) {
            return "-bye";
        }else if(input.trim().equals("-help")) {
            return "-help";
        }else if (dashIndex >= 0 && spaceIndex >= 0) {
            return input.substring(dashIndex, spaceIndex).trim();
        }
        return "null";
    }

    public static String cutInput(String input){
        int startIndex = input.indexOf("-");
        int endIndex = input.indexOf(" ");
        if (startIndex == -1 || endIndex == -1 || startIndex >= endIndex) {
            return null; // 字符串格式不正确，返回 null
        }
        String command = input.substring(startIndex + 1, endIndex).trim();
        String remaining = input.substring(endIndex + 1).replaceAll("\\s+", "");
        return remaining;
    }

    public static Integer consoleInput(String choice,String input) throws IOException {
        MyPatterns myPatterns = new MyPatterns();
        switch (choice){

            case "-sign":
                String signResult1 = myPatterns.sign(input);
                //System.out.println(myPatterns.getParts()[1]+" "+myPatterns.getParts()[2]+" "+myPatterns.getParts()[3]+" "+myPatterns.getParts()[4]);
                long signResult2 = OSign.sign(myPatterns.getParts()[1],myPatterns.getParts()[2],myPatterns.getParts()[3],myPatterns.getParts()[4]);
                if(signResult1.equals("OK")&&signResult2>0){
                    return 200;
                }else {
                    System.out.println("error "+signResult2);
                    return 401;
                }

            case "-login":
                String loginResult1 = myPatterns.login(input);

                long loginResult2 = OLogin.login(myPatterns.getOchoice(),myPatterns.getAccount());
                System.out.println(myPatterns.getOchoice()+" "+myPatterns.getAccount());
                if(loginResult1.equals("OK")&&loginResult2>-3001){
                    return 200;
                }else {
                    System.out.println("error "+loginResult2);
                    return 401;
                }

            case "-bye":
                System.out.println("Ending of The system");
                return 0;

            case "-buy":
                String buyResult1 = myPatterns.buy(input);
                Order buyResult2 = OBuy.buy(myPatterns.getBuyerAccount(),myPatterns.getSellerAccount(),myPatterns.getItem());
                System.out.println("Buy Result is "+buyResult2);
                return buyResult2.getStatus();

            case"-clear":
                String clearResult1 = myPatterns.clear(input);
                long clearResult2 = VUser.clearUser(myPatterns.getAccount(),myPatterns.getOtherAccount());
                if(clearResult1.equals("OK")&&clearResult2>0){
                    return 200;
                }else {
                    System.out.println("error "+clearResult2);
                    return 401;
                }
            case"-out":
                String outResult1 = myPatterns.iout(input);
                Integer outResult2= OOut.dataOut(myPatterns.getAccount(),myPatterns.getType());
                if(outResult1.equals("OK")&&outResult2>-300){
                    return 200;
                }else {
                    System.out.println("error "+outResult2);
                    return 401;
                }

            case"-in":
                String inResult1 = myPatterns.iout(input);
                Integer inResult2= OIn.dataOut(myPatterns.getAccount(),myPatterns.getType());
                if(inResult1.equals("OK")&&inResult2>-300){
                    return 200;
                }else {
                    System.out.println("error "+inResult2);
                    return 401;
                }

            case"-ls":
                String lsResult1 = myPatterns.ls(input);
                Integer lsResult2= VGet.ls(myPatterns.getAccount(),myPatterns.getType());
                if(lsResult1.equals("OK")&&lsResult2>-300){
                    return 200;
                }else {
                    System.out.println("error "+lsResult2);
                    return 401;
                }

            case "-detail" :
                String detailResult1 = myPatterns.detail(input);
                List<String> detailResult2 = VGet.detail(myPatterns.getAccount());
                if(detailResult1.equals("OK")&&detailResult2!=null){
                    System.out.println("Item Total Num is "   +detailResult2.get(0) );
                    System.out.println("Item Total Value is "+ detailResult2.get(3)+"\n");
                    System.out.println("User Total Num is "  + detailResult2.get(1));
                    System.out.println("User Total Value is "+ detailResult2.get(4)+"\n");
                    System.out.println("Order Total Num is " + detailResult2.get(2));
                    System.out.println("Order Total Value is "+ detailResult2.get(5)+"\n");
                    return 200;
                }else {
                    System.out.println("error "+detailResult2);
                    return 401;
                }

            case "-search":
                String searchResult1= myPatterns.search(input);
                List<String> searchResult2 = OSercher.dataSearch(myPatterns.getAccount(),myPatterns.getType(),myPatterns.getText());
                if(searchResult1.equals("OK")&&searchResult2!=null){
                    for (String s:searchResult2) {
                        System.out.println(VGet.getByOId(myPatterns.getAccount(), myPatterns.getType(),s));
                    }
                    StringListTemp = searchResult2;
                    return 200;
                }else {
                    System.out.println("error "+searchResult2);
                    return 401;
                }

            case "-update":
                String updateResult1 = myPatterns.update(input);
                Integer updateResult2;
                switch (myPatterns.getType()){
                    case "user":
                        updateResult2 = OUpdate.update(myPatterns.getAccount(),myPatterns.getType(),myPatterns.getParts()[1],myPatterns.getNewUser()); break;
                    case "item":
                        updateResult2 = OUpdate.update(myPatterns.getAccount(),myPatterns.getType(),myPatterns.getParts()[1],myPatterns.getNewItem()); break;
                    case "order":
                        updateResult2 = OUpdate.update(myPatterns.getAccount(),myPatterns.getType(),myPatterns.getParts()[1],myPatterns.getNewOrder()); break;
                    default: return 401;
                }
                if(updateResult1.equals("OK")&&updateResult2>=-300){
                    return 200;
                }else {
                    System.out.println("error "+updateResult2);
                    return 401;
                }

            case "-x":
                System.out.println("Welcome to Terminal mode. * "+myAccount.getOId());
                return 999;

            case "-help":
                System.out.println(Help.helpText);
                return 200;

            default:
                System.out.println("$"+choice+"$");
                System.out.println("YOUR input seems a bit wrong...");
                break;
        }
        return 0;
    }

}
