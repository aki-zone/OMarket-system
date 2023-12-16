package com.As.VO;

public class Help {
    public static String helpText = "您好。O二手交易系统指令集如下：\n" +
            "\n" +
            "//登陆指令集\n" +
            "-login [\"1\"][account:[phoneNum=\"\",password=\"\"]]   \t\n" +
            "-login [\"2\"][account:[OId=\"\",password=\"\"]]\n" +
            "\n" +
            "\n" +
            "//注册指令集\n" +
            "\n" +
            "-sign [\"__username__\"][\"__phoneNum(不可重复)__\"][\"__password__\"][\"__balances(须是正浮点/整值)__\"]\n" +
            "-sign [\"\"][\"\"][\"\"][\"\"]\n" +
            "\n" +
            "\n" +
            "//交易指令集(需保证卖家货物充足，买家资金充足)\n" +
            "\n" +
            "-buy [buyerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][sellerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][item:[OId=\"__(必填)__\",name=\"__(不填)__\",description=\"__(不填)__\",price=\"\",num=\"__(必填)__\"]]\n" +
            "-buy [buyerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][sellerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][item:[OId=\"\",name=\"\",description=\"\",price=\"\",num=\"\"]]\n" +
            "\n" +
            "\n" +
            "//注销指令集  *权限9\n" +
            "\n" +
            "-clear [ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][otherAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]]\n" +
            "-clear [ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][otherAccount:[OId=\"\",phoneNum=\"\",password=\"\"]]\n" +
            "\n" +
            "\n" +
            "//打印、导入、输出指令集 *权限9\n" +
            "/*\n" +
            "    //[Type=\"cate\"]\n" +
            "    //[Type=\"user\"]\n" +
            "    //[Type=\"item\"]\n" +
            "    //[Type=\"order\"]\n" +
            "    //[Type=\"user-item\"]\n" +
            "    //[Type=\"item-cate\"]\n" +
            "*/\n" +
            "-in [ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][Type=\"__(必填)__\"]\n" +
            "-out[ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][Type=\"__(必填)__\"]\n" +
            "-ls [ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][Type=\"__(必填)__\"]\n" +
            "\n" +
            "-in [ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][Type=\"\"]\n" +
            "-out[ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][Type=\"\"]\n" +
            "-ls [ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][Type=\"\"]\n" +
            "\n" +
            "\n" +
            "//统计指令集 *权限9\n" +
            "\n" +
            "-detail [ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]]\n" +
            "-detail [ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]]\n" +
            "\n" +
            "\n" +
            "//查询指令集 *权限9\n" +
            "/*\n" +
            "    //[Type=\"cate\"]\n" +
            "    //[Type=\"user\"]\n" +
            "    //[Type=\"item\"]\n" +
            "    //[Type=\"order\"]\n" +
            "    //[Type=\"user-item\"]\n" +
            "    //[Type=\"item-cate\"]\n" +
            "*/\n" +
            "/*\n" +
            "    //[Text=\"任意字符串\"]\n" +
            "*/\n" +
            "-search [ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][Type=\"__(必填)__\"][Text=\"__(必填)__\"]\n" +
            "-search [ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][Type=\"\"][Text=\"\"]\n" +
            "\n" +
            "\n" +
            "//修改指令集  *通用权限\n" +
            "\n" +
            "-update \t   \t\t\t普通\t\t\t\t\t\t\t\t\t\t\t管理\t\t\t\t\t\n" +
            "[UserId] [newUser]  [自己，只有username，password，address，mail，username]\t   [所有人，所有值除了OId]\n" +
            "[OrderId] [Order]   [自己的status ,且只能向下]\t\t\t\t   [所有人，所有值除了OId]\n" +
            "[ItemId] [newItem]  [自己,除了OId]\t\t\t\t\t   [所有人，所有值除了OId]\n" +
            "\n" +
            "//以下打星代表管理权限才可修改\n" +
            "\n" +
            "\n" +
            "-update [ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][UserId=\"__(必填,普通用户仅能修改自己)__\"]\n" +
            "[newUser:[OId=\"__(不填)__\", status=__(选填*)__, username=\"__(选填)__\", password=\"__(选填)__\", phoneNum=\"__(选填*)__\", email=\"__(选填)__\", address=\"__(选填)__\", regsTime=\"__(选填*)__\", balances=\"__(选填*)__\"]]\n" +
            "\n" +
            "-update [ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][OrderId=\"__(必填，普通用户仅能修改自己拥有的)__\"][newOrder:[OId=\"__(不填)__\",status=__(选填)__,buyerId=\"__(选填*)__\",sellerId=\"__(选填*)__\",itemsId=\"__(选填*)__\",time=\"__(选填*)__\",num=__(选填*)__,value=\"__(选填*)__\"]]\n" +
            "\n" +
            "-update [ManagerAccount:[OId=\"__(必填)__\",phoneNum=\"\",password=\"__(必填)__\"]][ItemId=\"__(必填，普通用户仅能修改自己拥有的)__\"][newItem:[OId=\"__(不填)__\",name=\"__(选填)__\",description=\"__(选填)__\",price=\"\",num=__(选填)__]]\n" +
            "\n" +
            "\n" +
            "-update [ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][UserId=\"\"][newUser:[OId=\"\", status=\\, username=\"\", password=\"\", phoneNum=\"\", email=\"\", address=\"\", regsTime=\"\",balances=\"\"]]\n" +
            "\n" +
            "-update [ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][OrderId=\"\"][newOrder:[OId=\"\",status=,buyerId=\"\",sellerId=\"\",itemsId=\"\",time=\"\",num=,value=\"\"]]\n" +
            "\n" +
            "-update [ManagerAccount:[OId=\"\",phoneNum=\"\",password=\"\"]][ItemId=\"\"][newItem:[OId=\"\",name=\"\",description=\"\",price=\"\",num=]]\n" +
            "\n" +
            "\n" +
            "//退出\n" +
            "\n" +
            "-bye\n" +
            "\n";

}
