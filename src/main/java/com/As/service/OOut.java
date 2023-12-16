package com.As.service;

import com.As.VO.*;
import com.As.dao.IUserDAO;
import com.As.util.MybatisUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class OOut {
    private static String PATH      = "src\\main\\resources\\XlsOutDatas\\";
    private static String CATENAME  = "category.xlsx";
    private static String ITEMNAME  = "item.xlsx";
    private static String ORDERNAME = "order.xlsx";
    private static String USERNAME  = "user.xlsx";
    private static String UINAME    = "user_item.xlsx";
    private static String ICNAME    = "item_category.xlsx";
    private static Integer OAuthority = 9;


    public static Integer cateOut(Account account) throws IOException {

        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return -401;
        }
        Path filePath = Paths.get(PATH + CATENAME);
        Fishave(CATENAME,filePath);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        List<Category> cateList= VGet.getCateList(account);
        String[] CateTableName = new String[]{"[Category.OId]","[Category.name]"};

        Row TableRow = sheet.createRow(0);

        for(int i = 0;i < CateTableName.length;i++){
            Cell Tablecell = TableRow.createCell(i);
            Tablecell.setCellValue(CateTableName[i]);
        }

        int rowCount = 1;
        for (Category cate : cateList) {
            int columnCount = 0;
            Row dataRow = sheet.createRow(rowCount++);

            Cell cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(cate.getOId(),8,'0'));
                 cell = dataRow.createCell(columnCount++);
            cell.setCellValue(cate.getName());
            }

            Fwrite(CATENAME, workbook);
        return -200;
    }

    public static Integer itemOut(Account account) throws IOException {
        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return -401;
        }
        Path filePath = Paths.get(PATH + ITEMNAME);
        Fishave(ITEMNAME,filePath);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        List<Item> itemList= VGet.getItemList(account);
        String[] ItemTableName = new String[]{"[Item.OId]","[Item.name]","[Item.description]","[Item.price]","[Item.num]"};

        Row TableRow = sheet.createRow(0);

        for(int i = 0;i < ItemTableName.length;i++){
            Cell Tablecell = TableRow.createCell(i);
            Tablecell.setCellValue(ItemTableName[i]);
        }

        int rowCount = 1;
        for (Item item : itemList) {
            int columnCount = 0;
            Row dataRow = sheet.createRow(rowCount++);

            Cell cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(item.getOId(),20,'0'));
                 cell = dataRow.createCell(columnCount++);
            cell.setCellValue(item.getName());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(item.getDescription());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(item.getPrice());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(item.getNum());
        }

        Fwrite(ITEMNAME, workbook);
        return -200;
    }

    public static Integer orderOut(Account account) throws IOException {
        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }
        Path filePath = Paths.get(PATH + ORDERNAME);
        Fishave(ORDERNAME,filePath);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        List<Order> orderList = VGet.getOrderList(account);
        String[] OrderTableName = new String[]{"[Order.OId]","[Order.status]","[Order.buyerId]","[Order.sellerId]","[Order.itemId]","[Order.time]","[Order.num]","[Order.value]"};

        Row TableRow = sheet.createRow(0);

        for(int i = 0;i < OrderTableName.length;i++){
            Cell Tablecell = TableRow.createCell(i);
            Tablecell.setCellValue(OrderTableName[i]);
        }

        int rowCount = 1;
        for (Order order : orderList) {
            int columnCount = 0;
            Row dataRow = sheet.createRow(rowCount++);

            Cell cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(order.getOId(),22,'0'));
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(order.getStatus());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(order.getBuyerId(),15,'0'));
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(order.getSellerId(),15,'0'));
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(order.getItemsId(),20,'0'));
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(order.getTime());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(order.getNum());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(order.getValue());
        }

        Fwrite(ORDERNAME, workbook);
        return -200;
    }

    public static Integer userOut(Account account) throws IOException {
        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }
        Path filePath = Paths.get(PATH + USERNAME);
        Fishave(USERNAME,filePath);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        List<User> userList = VGet.getUserList(account);
        String[] UserTableName = new String[]{"[User.OId]","[User.status]","[User.username]","[User.password]","[User.phoneNum]","[User.email]","[User.address]","[User.balances]","[User.regsTime]"};

        Row TableRow = sheet.createRow(0);

        for(int i = 0;i < UserTableName.length;i++){
            Cell Tablecell = TableRow.createCell(i);
            Tablecell.setCellValue(UserTableName[i]);
        }

        int rowCount = 1;
        for (User us : userList) {
            int columnCount = 0;
            Row dataRow = sheet.createRow(rowCount++);

            Cell cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(us.getOId(),15,'0'));
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(us.getStatus());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(us.getUsername());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(us.getPassword());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(us.getPhoneNum());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(us.getEmail());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(us.getAddress());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(us.getBalances());
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(us.getRegsTime());
        }

        Fwrite(USERNAME, workbook);
        return -200;
    }

    public static Integer UIOut(Account account) throws IOException {
        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }
        Path filePath = Paths.get(PATH + UINAME);
        Fishave(UINAME,filePath);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        List<User_Item> uiList = VGet.getUIList(account);
        String[] UITableName = new String[]{"[User.OId]","[Item.OId]","[Total]"};

        Row TableRow = sheet.createRow(0);

        for(int i = 0;i < UITableName.length;i++){
            Cell Tablecell = TableRow.createCell(i);
            Tablecell.setCellValue(UITableName[i]);
        }

        int rowCount = 1;
        for (User_Item ui : uiList) {
            int columnCount = 0;
            Row dataRow = sheet.createRow(rowCount++);

            Cell cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(ui.getUserId(),15,'0'));
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(ui.getItemsId(),20,'0'));
                cell = dataRow.createCell(columnCount++);
            cell.setCellValue(ui.getNum());
        }

        Fwrite(UINAME, workbook);
        return -200;
    }


    public static Integer ICOut(Account account) throws IOException {

        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }
        Path filePath = Paths.get(PATH + ICNAME);
        Fishave(ICNAME,filePath);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        List<Item_Category> icList = VGet.getICList(account);
        String[] ICTableName = new String[]{"[User.OId]","[Category.OId]"};

        Row TableRow = sheet.createRow(0);

        for(int i = 0;i < ICTableName.length;i++){
            Cell Tablecell = TableRow.createCell(i);
            Tablecell.setCellValue(ICTableName[i]);
        }

        int rowCount = 1;
        for (Item_Category ic : icList) {
            int columnCount = 0;
            Row dataRow = sheet.createRow(rowCount++);

            Cell cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(ic.getItemsId(),20,'0'));
                 cell = dataRow.createCell(columnCount++);
            cell.setCellValue(StringUtils.leftPad(ic.getCategoryId(),8,'0'));
        }

        Fwrite(ICNAME, workbook);
        return -200;
    }

    /*sub function*/
    public static void Fwrite(String FILENAME,Workbook workbook) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(PATH + FILENAME, true);
            workbook.write(outputStream);
            System.out.println("Excel file Write in success！"+ PATH + FILENAME);
            outputStream.close();

    }

    //*sub function*//
    public static Integer dataOut(Account account,String choice) throws IOException {
        switch (choice){
            case "user": return userOut(account);
            case "item": return itemOut(account);
            case "order":return orderOut(account);
            case "cate": return cateOut(account);
            case "item-cate":return ICOut(account);
            case "user-item":return UIOut(account);
            default:return -404;
        }
    }


    public static Integer check(Account account){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
        return mapper.getByOId(account.getOId()).getStatus();
    }

    public static void Fishave(String FILENAME, Path filePath){
        if (Files.exists(filePath)) {
            try {
                Files.delete(filePath);
                System.out.println("Covering File Write In：" + FILENAME);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



