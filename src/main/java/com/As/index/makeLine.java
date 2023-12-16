package com.As.index;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.VO.Order;
import com.As.VO.User;

public class makeLine {
    private static final String LOGIN_LINE1 ="[\"__x1__\"][account:[phoneNum=\"__x2__\",password=\"__x3__\"]]";
    private static final String LOGIN_LINE2 = "[\"__x1__\"][account:[OId=\"__x2__\",password=\"__x3__\"]]";
    private static final String SIGN_LINE = "[\"__x1__\"][\"__x2__\"][\"__x3__\"][\"__x4__\"]";
    private static final String BUY_LINE ="[buyerAccount:[OId=\"__x1__\",phoneNum=\"__x2__\",password=\"__x3__\"]][sellerAccount:[OId=\"__x4__\",phoneNum=\"__x5__\",password=\"__x6__\"]] [item:[OId=\"__x7__\",name=\"__x8__\",description=\"__x9__\",price=\"__x10__\",num=\"__x11__\"]]";
    private static final String CLEAR_LINE ="[ManagerAccount:[OId=\"__x1__\",phoneNum=\"__x2__\",password=\"__x3__\"]][otherAcount:[OId=\"__x4__\",phoneNum=\"__x5__\",password=\"__x6__\"]]";
    private static final String IOUT_LINE = "[ManagerAccount:[OId=\"__x1__\",phoneNum=\"__x2__\",password=\"__x3__\"]][Type=\"__x4__\"]";
    private static final String SEARCH = "[ManagerAccount:[OId=\"__x1__\",phoneNum=\"__x2__\",password=\"__x3__\"]][Type=\"__x4__\"][Text=\"__x5__\"]";
    private static final String DETAIL = "[ManagerAccount:[OId=\"__x1__\",phoneNum=\"__x2__\",password=\"__x3__\"]]";
    private static final String LS = "[ManagerAccount:[OId=\"__x1__\",phoneNum=\"__x2__\",password=\"__x3__\"]][Type=\"__x4__\"]";
    private static final String UPDATE_USER ="[ManagerAccount:[OId=\"1\",phoneNum=\"\",password=\"111111\"]][UserId=\"\"][newUser:[OId=\"__x1__\", status=\"2\", username=\"__x3__\", password=\"__x4__\", phoneNum=\"__x5__\", email=\"__x6__\", address=\"__x7__\",regsTime=\"__x8__\",balances=\"__x9__\"]]";
    private static final String UPDATE_ORDER ="[ManagerAccount:[OId=\"__x1__\",phoneNum=\"__x2__\",password=\"__x3__\"]][OrderId=\"__x4__\"][newOrder:[OId=\"__x5__\",status=\"__x6__\",buyerId=\"__x7__\",sellerId=\"__x8__\",itemsId=\"__x9__\",time=\"__x10__\",num=\"__x11__\",value=\"__x12__\"]]";
    private static final String UPDATE_ITEM ="[ManagerAccount:[OId=\"__x1__\",phoneNum=\"__x2__\",password=\"__x3__\"]][ItemId=\"__x4__\"][newItem:[OId=\"__x5__\",name=\"__x6__\",description=\"__x7__\",price=\"__x8__\",num=\"__x9__\"]]";

    public static String login(String choice, Account account){
        String template;
        if (choice.equals("1")) {
            template = new String(LOGIN_LINE1);
            template=template.replace("__x2__",account.getPhoneNum());
        }else {
            template = new String(LOGIN_LINE2);
            template=template.replace("__x2__",account.getOId());
        }

        template=template.replace("__x1__",choice);
        template=template.replace("__x3__",account.getPassword());

        return template.replace(" ","");
    }

    public static String sign(String username,String phoneNum,String password,String balances){
        String template = new String(SIGN_LINE);
        template=template.replace("__x1__",username);
        template=template.replace("__x2__",phoneNum);
        template=template.replace("__x3__",password);
        template=template.replace("__x4__",balances);
        return template.replace(" ","");
    }

    public static String buy(Account buyer, Account seller, Item item){
        String template = new String(SIGN_LINE);
        template = template.replace("__x1__", buyer.getOId());
        template = template.replace("__x2__", buyer.getPhoneNum());
        template = template.replace("__x3__", buyer.getPassword());
        template = template.replace("__x4__", seller.getOId());
        template = template.replace("__x5__", seller.getPhoneNum());
        template = template.replace("__x6__", seller.getPassword());
        template = template.replace("__x7__", item.getOId());
        template = template.replace("__x8__", item.getName());
        template = template.replace("__x9__", item.getDescription());
        template = template.replace("__x10__", String.valueOf(item.getPrice()));
        template = template.replace("__x11__", String.valueOf(item.getNum()));
        return template.replace(" ","");
    }

    public static String clear(Account ManagerAccount,Account otherAccount){
        String template = new String(CLEAR_LINE);
        template = template.replace("__x1__", ManagerAccount.getOId());
        template = template.replace("__x2__", ManagerAccount.getPhoneNum());
        template = template.replace("__x3__", ManagerAccount.getPassword());
        template = template.replace("__x4__", otherAccount.getOId());
        template = template.replace("__x5__", otherAccount.getPhoneNum());
        template = template.replace("__x6__", otherAccount.getPassword());
        return template.replace(" ","");
    }

    public static String iout(Account ManagerAccount,String Type){
        String template = new String(IOUT_LINE);
        template = template.replace("__x1__", ManagerAccount.getOId());
        template = template.replace("__x2__", ManagerAccount.getPhoneNum());
        template = template.replace("__x3__", ManagerAccount.getPassword());
        template = template.replace("__x4__", Type);
        return template.replace(" ","");
    }

    public static String search(Account ManagerAccount, String Type, String text) {
        String template = new String(SEARCH);
        template = template.replace("__x1__", ManagerAccount.getOId());
        template = template.replace("__x2__", ManagerAccount.getPhoneNum());
        template = template.replace("__x3__", ManagerAccount.getPassword());
        template = template.replace("__x4__", Type);
        template = template.replace("__x5__", text);
        return template.replace(" ","");
    }

    public static String detail(Account managerAccount) {
        String template = new String(DETAIL);
        template = template.replace("__x1__", managerAccount.getOId());
        template = template.replace("__x2__", managerAccount.getPhoneNum());
        template = template.replace("__x3__", managerAccount.getPassword());
        return template.replace(" ","");
    }

    public static String ls(Account managerAccount, String type) {
        String template = new String(LS);
        template = template.replace("__x1__", managerAccount.getOId());
        template = template.replace("__x2__", managerAccount.getPhoneNum());
        template = template.replace("__x3__", managerAccount.getPassword());
        template = template.replace("__x4__", type);
        return template.replace(" ","");
    }

    public static String updateUser(Account ManagerAccount, String oldUserId, User newUser) {
        String template = new String(UPDATE_USER);
        template = template.replace("__x1__", ManagerAccount.getOId());
        template = template.replace("__x2__", ManagerAccount.getPhoneNum());
        template = template.replace("__x3__", ManagerAccount.getPassword());
        template = template.replace("__x4__", oldUserId);
        template = template.replace("__x5__", newUser.getOId());
        template = template.replace("__x6__", String.valueOf(newUser.getStatus()));
        template = template.replace("__x7__", newUser.getUsername());
        template = template.replace("__x8__", newUser.getPassword());
        template = template.replace("__x9__", newUser.getPhoneNum());
        template = template.replace("__x10__", newUser.getEmail());
        template = template.replace("__x11__", newUser.getAddress());
        template = template.replace("__x12__", newUser.getRegsTime());
        template = template.replace("__x13__", String.valueOf(newUser.getBalances()));
        return template.replace(" ","");
    }

    public static String updateOrder(Account ManagerAccount, String oldOrderId, Order newOrder) {
        String template = new String(UPDATE_ORDER);
        template = template.replace("__x1__", ManagerAccount.getOId());
        template = template.replace("__x2__", ManagerAccount.getPhoneNum());
        template = template.replace("__x3__", ManagerAccount.getPassword());
        template = template.replace("__x4__", oldOrderId);
        template = template.replace("__x5__", newOrder.getOId());
        template = template.replace("__x6__", String.valueOf(newOrder.getStatus()));
        template = template.replace("__x7__", newOrder.getBuyerId());
        template = template.replace("__x8__", newOrder.getSellerId());
        template = template.replace("__x9__", newOrder.getItemsId());
        template = template.replace("__x10__", newOrder.getTime());
        template = template.replace("__x11__", String.valueOf(newOrder.getNum()));
        template = template.replace("__x12__", newOrder.getValue());
        return template.replace(" ","");
    }

    public static String updateItem(Account ManagerAccount, String oldItemId, Item newItem) {
        String template = new String(UPDATE_ITEM);
        template = template.replace("__x1__", ManagerAccount.getOId());
        template = template.replace("__x2__", ManagerAccount.getPhoneNum());
        template = template.replace("__x3__", ManagerAccount.getPassword());
        template = template.replace("__x4__", oldItemId);
        template = template.replace("__x5__", newItem.getOId());
        template = template.replace("__x6__", newItem.getName());
        template = template.replace("__x7__", newItem.getDescription());
        template = template.replace("__x8__", String.valueOf(newItem.getPrice()));
        template = template.replace("__x9__", String.valueOf(newItem.getNum()));
        return template.replace(" ","");
    }


}
