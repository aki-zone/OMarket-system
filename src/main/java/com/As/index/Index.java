package com.As.index;

import com.As.VO.Account;
import com.As.VO.Item;
import com.As.VO.Order;
import com.As.VO.User;
import com.As.dao.IUserDAO;
import com.As.service.CommandLine;
import com.As.service.OWindows;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
public class Index {

    public static Account myAccount = new Account("1","111111");
    public static String OLine = new String();

    public static Item itemTemp;
    public static User userTemp;
    public static Order orderTemp;
    public static String stringTemp;
    public static String choice[]=new String[20];

    public static boolean isLogin = false;
    public static void main(String[] args) throws IOException {

        while (true){
            while (true){
                clearCmd();
                OWindows.OOutln("请输入[1]选择注册新账号，输入[2]选择登录,输入[3]进入指令集模式，输入任意其他键退出程序。");
                choice[0] = OWindows.ONextLine();
                if (choice[0].equals("1")){
                    OWindows.OOut("输入用户名："); choice[1]=OWindows.ONextLine();
                    OWindows.OOut("请输入电话号码【不可重复】："); choice[2]=OWindows.ONextLine();
                    OWindows.OOut("输入密码："); choice[3]=OWindows.ONextLine();
                    OWindows.OOut("输入余额【输入后不可随意更改】"); choice[4]=OWindows.ONextLine();
                    appendCmd("-sign ");
                    appendCmd(makeLine.sign(choice[1],choice[2],choice[3],choice[4]));
                    if(run()<300){

                        OWindows.OOutln(choice[1]+" 注册成功！请返回登录！");
                        break;
                    } else {
                        OWindows.OOutln("注册失败，可能是您的手机号重复了。请重新开始吧！ \n");
                    }
                }else if (choice[0].equals("2")){
                    break;
                }else if(choice[0].equals("3")){
                    clearCmd(); run("-x");
                    while(true){
                        String cmdLine =  OWindows.ONextLine();
                        OWindows.OOutln(cmdLine+"  运行中。。。");
                        run(cmdLine);
                    }
                }else {
                    OLine = "-bye";
                    run();
                }
            }

            while (true){
                clearCmd();
                OWindows.OOutln("请登录。 依次输入选择：\n输入【1】，选择 电话号码 + 密码 登录；\n 输入【2】，选择 OId + 密码 登录；");
                choice[1]=OWindows.ONextLine();
                if(choice[1].equals("2")) {
                    myAccount.setOId(OWindows.ONextLine());
                }else {
                    myAccount.setPhoneNum(OWindows.ONextLine());
                }
                myAccount.setPassword(OWindows.ONextLine());
                OLine = "-login "+makeLine.login(choice[1],myAccount);
                System.out.println(OLine);

                if(run()<300){
                    OWindows.OOutln("登陆成功，正在保存账号信息。");
                    SqlSession sqlSession = MybatisUtils.getSqlSession();
                    IUserDAO iUserTemp = sqlSession.getMapper(IUserDAO.class);
                    if(choice[1].equals("2")) {
                        userTemp = iUserTemp.getByOP(myAccount.getOId(),myAccount.getPassword());
                    }else {
                        userTemp = iUserTemp.getByPP(myAccount.getPhoneNum(),myAccount.getPassword());
                    }
                    myAccount.setOId(userTemp.getOId());
                    myAccount.setPassword(userTemp.getPassword());
                    myAccount.setPhoneNum(userTemp.getPhoneNum());
                    sqlSession.close();
                    break;
                }
            }
            while (true){
                OWindows.OOutln("---------交易系统--------");
                OWindows.OOut("欢迎你！");
                System.out.println(myAccount);
                if(check(myAccount)>=9){
                    OWindows.OOutln("您是管理员！");
                    OWindows.OOutln("-sign  [String:username][String:phoneNum][String:password][String:balances] 注册指令集");
                    OWindows.OOutln("-buy   [Account buyerAccount][Account sellerAcount][Item item] 购物指令集");
                    OWindows.OOutln("-clear [Account ManagerAccount][Account otherAcount] 注销账户");
                    OWindows.OOutln("-out[Account ManagerAccount][String Type] 导出数据\n" +
                                         "-in [Account ManagerAccount][String Type] 导入数据\n" +
                                         "-ls [Account ManagerAccount][String Type] 输出数据");
                    OWindows.OOutln("-detail  [Account Manageraccount] 输出统计数值");
                    OWindows.OOutln("-search [Account ManagerAccount][String Type][String Text] 模糊查询");
                    OWindows.OOutln("-update \n"+
                            "[UserId]  [newUser]  \n" +
                            "[OrderId] [Order]    \n" +
                            "[ItemId]  [newItem] ");
                    OWindows.OOutln("-bye 退出");

                }else {
                    OWindows.OOut("您是普通用户！");
                    OWindows.OOutln("-sign [String:username][String:phoneNum][String:password][String:balances] 注册指令集");
                    OWindows.OOutln("-buy -buy [Account buyerAccount][Account sellerAcount][Item item] 购物指令集");
                    OWindows.OOutln("-update \n"+
                            "[UserId]  [newUser]  [自己，只有username，password，address，mail，username]\n" +
                            "[OrderId] [Order]    [自己的status ,且只能向下]\n" +
                            "[ItemId]  [newItem] ");
                    OWindows.OOutln("-bye 退出");
                }
                String cmdLine =  OWindows.ONextLine();
                OWindows.OOutln(cmdLine+"  运行中。。。");
                run(cmdLine);
            }
        }


    }

    public static void clearCmd(){
        OLine = "";
        choice = new String[20];
    }
    public static void appendCmd(String x){
        OLine += x;
    }

    public static Integer run() throws IOException {
        Integer result =  CommandLine.consoleInput(CommandLine.watchInPut(OLine),CommandLine.cutInput(OLine));
        if (result == 999) {
            System.out.println("正在开启终端模式...");
        }System.out.println("运行结果编码为 "+result);
        return result;
    }

    public static Integer run(String input) throws IOException {
        Integer result =  CommandLine.consoleInput(CommandLine.watchInPut(input),CommandLine.cutInput(input));
        if (result == 999){
            System.out.println("正在开启终端模式...");
        }System.out.println("运行结果编码为 "+result);
        return result;
    }

    public static Integer check(Account account){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
            return mapper.getByOId(account.getOId()).getStatus();
        }
    }
}
