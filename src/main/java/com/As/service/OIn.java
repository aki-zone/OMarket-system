package com.As.service;

import com.As.VO.*;
import com.As.dao.IUserDAO;
import com.As.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class OIn {

    private static Account account = new Account("1","111111");
    private static String PATH      = "src\\main\\resources\\XlsInDatas\\";
    private static String CATENAME  = "category.xlsx";
    private static String ITEMNAME  = "item.xlsx";
    private static String ORDERNAME = "order.xlsx";
    private static String USERNAME  = "user.xlsx";
    private static String UINAME    = "user_item.xlsx";
    private static String ICNAME    = "item_category.xlsx";
    private static Integer OAuthority = 9;

    public static Integer cateIn(Account account) throws IOException {

        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }

        Path filePath = Paths.get(PATH + CATENAME);
        if(!Fishave(CATENAME,filePath)){
            System.out.println(CATENAME +" IN "+filePath+" NOT FOUND.");
        }

        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath.toString())) ;
        Sheet sheet = workbook.getSheet("Sheet1");


        for (Row row : sheet) {
            if(row.getRowNum()==0){
                continue;
            }
            Cell cell ;
            Category category = new Category();
            cell= row.getCell(0);
            if(cell!=null){
                category.setOId(turnString(cell));
            }

            cell= row.getCell(1);
            if(cell!=null){
                category.setName(turnString(cell));
            }

            if (!VGet.CateHaveId(account,category.getOId())
                &&!VGet.CateHaveName(account,category.getName())
                &&!"".equals(category.getOId())
                &&!"".equals(category.getName())          ){
                long insertRow = VGet.CateInsert(account,category);
                System.out.print("Category Table add "+category.getOId()+"  "+category.getName());
                isSuccess(insertRow);
            }
        }
        return -200;
    }


    public static Integer itemIn(Account account) throws IOException {

        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }

        Path filePath = Paths.get(PATH + ITEMNAME);
        if(!Fishave(ITEMNAME,filePath)){
            System.out.println(ITEMNAME +" IN "+filePath+" NOT FOUND.");
        }

        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath.toString())) ;
        Sheet sheet = workbook.getSheet("Sheet1");


        for (Row row : sheet) {
            if(row.getRowNum()==0){
                continue;
            }
            Cell cell ;
            Item item = new Item();
            cell= row.getCell(0);
            if(cell!=null){
                item.setOId(turnString(cell));
            }

            cell= row.getCell(1);
            if(cell!=null){
                item.setName(turnString(cell));
            }
            cell= row.getCell(2);
            if(cell!=null){
                item.setDescription(turnString(cell));
            }
            cell= row.getCell(3);
            if(cell!=null){
                item.setPrice(turnString(cell));
            }
            cell= row.getCell(4);
            if(cell!=null){
                item.setNum((int) cell.getNumericCellValue());
            }

            if (!VGet.ItemHaveId(account,item.getOId())){
                long insertRow;
                if("".equals(item.getOId())){
                    insertRow = VGet.ItemInsertNull(account,item);
                }else {
                    insertRow = VGet.ItemInsert(account,item);
                }

                System.out.print("Item Table add "+item.getOId()+"  "+item.getName());
                isSuccess(insertRow);
            }
        }
        return -200;
    }


    public static Integer orderIn(Account account) throws IOException {

        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }

        Path filePath = Paths.get(PATH + ORDERNAME);
        if (!Fishave(ORDERNAME, filePath)) {
            System.out.println(ORDERNAME + " IN " + filePath + " NOT FOUND.");
        }

        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath.toString()));
        Sheet sheet = workbook.getSheet("Sheet1");


        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell cell;
            Order order = new Order();

            cell = row.getCell(0);
            if (cell != null) {
                order.setOId(turnString(cell));
            }

            cell = row.getCell(1);
            if (cell != null) {
                order.setStatus((int) cell.getNumericCellValue());
            }
            cell = row.getCell(2);
            if (cell != null) {
                order.setBuyerId(turnString(cell));
            }
            cell = row.getCell(3);
            if (cell != null) {
                order.setSellerId(turnString(cell));
            }
            cell = row.getCell(4);
            if (cell != null) {
                order.setItemsId(turnString(cell));
            }
            cell = row.getCell(5);
            if (cell != null) {
                order.setTime(turnString(cell));
            }
            cell = row.getCell(6);
            if (cell != null) {
                order.setNum((int) cell.getNumericCellValue());
            }
            cell = row.getCell(7);
            if (cell != null) {
                order.setValue(turnString(cell));
            }


            if (!VGet.OrderHaveId(account, order.getOId())) {
                long insertRow;
                if ("".equals(order.getOId())) {
                    insertRow = VGet.OrderInsertNull(account, order);
                } else {
                    insertRow = VGet.OrderInsert(account, order);
                }

                System.out.print("Order Table add " + order.getOId() + "  " + order.getStatus());
                isSuccess(insertRow);
            }
        }
        return -200;
    }


    public static Integer userIn(Account account) throws IOException {

        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }
        Path filePath = Paths.get(PATH + USERNAME);
        if (!Fishave(USERNAME, filePath)) {
            System.out.println(USERNAME + " IN " + filePath + " NOT FOUND.");
        }

        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath.toString()));
        Sheet sheet = workbook.getSheet("Sheet1");


        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell cell;
            User user = new User();

            cell = row.getCell(0);
            if (cell != null) {
                user.setOId(turnString(cell));
            }

            cell = row.getCell(1);
            if (cell != null) {
                user.setStatus((int) cell.getNumericCellValue());
            }
            cell = row.getCell(2);
            if (cell != null) {
                user.setUsername(turnString(cell));
            }
            cell = row.getCell(3);
            if (cell != null) {
                user.setPassword(turnString(cell));
            }
            cell = row.getCell(4);
            if (cell != null) {
                user.setPhoneNum(turnString(cell));
            }
            cell = row.getCell(5);
            if (cell != null) {
                user.setEmail(turnString(cell));
            }
            cell = row.getCell(6);
            if (cell != null) {
                user.setAddress(turnString(cell));
            }
            cell = row.getCell(7);
            if (cell != null) {
                user.setBalances(turnString(cell));
            }
            cell = row.getCell(8);
            if (cell != null) {
                user.setRegsTime(turnString(cell));
            }


            if (!VGet.UserHaveId(account, user.getOId())
                    &&!VGet.UserHavePhone(account,user.getPhoneNum())
                    &&!"".equals(user.getPhoneNum())) {
                long insertRow;
                if ("".equals(user.getOId())) {
                    insertRow = VGet.UserInsertNull(account, user);
                } else {
                    insertRow = VGet.UserInsert(account, user);
                }

                System.out.print("User Table add " + user.getOId() + "  " + user.getStatus());
                isSuccess(insertRow);
            }
        }
        return -200;
    }


    public static Integer UIIn(Account account) throws IOException {
        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }
        Path filePath = Paths.get(PATH + UINAME);
        if (!Fishave(UINAME, filePath)) {
            System.out.println(UINAME + " IN " + filePath + " NOT FOUND.");
        }

        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath.toString()));
        Sheet sheet = workbook.getSheet("Sheet1");


        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell cell;
            User_Item user_item = new User_Item();

            cell = row.getCell(0);
            if (cell != null) {
                user_item.setUserId(turnString(cell));
            }
            cell = row.getCell(1);
            if (cell != null) {
                user_item.setItemId(turnString(cell));
            }
            cell = row.getCell(2);
            if (cell != null) {
                user_item.setNum((int) cell.getNumericCellValue());
            }


            if (!VGet.User_ItemHave(account, user_item)
                    &&!"".equals( user_item.getItemsId() )
                    &&!"".equals( user_item.getUserId() ) ) {
                long insertRow  = VGet.User_ItemInsert(account,user_item);
                System.out.print("User_Item Table add " +user_item.getUserId()+ "  " +user_item.getItemsId()+"  "+user_item.getNum());
                isSuccess(insertRow);

            }
        }
        return -200;
    }


    public static Integer ICIn(Account account) throws IOException {

        if(check(account)<OAuthority||check(account)<VGet.getOAuthority()){
            return 401;
        }
        Path filePath = Paths.get(PATH + ICNAME);
        if (!Fishave(ICNAME, filePath)) {
            System.out.println(ICNAME+ " IN " + filePath + " NOT FOUND.");
        }

        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath.toString()));
        Sheet sheet = workbook.getSheet("Sheet1");


        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            Cell cell;
            Item_Category item_category = new Item_Category();

            cell = row.getCell(0);
            if (cell != null) {
                item_category.setItemsId(turnString(cell));
            }
            cell = row.getCell(1);
            if (cell != null) {
                item_category.setCategoryId(turnString(cell));
            }

            if (!VGet.Item_CateHave(account, item_category)
                    &&!"".equals( item_category.getItemsId() )
                    &&!"".equals( item_category.getCategoryId() )  ) {
                long insertRow  = VGet.Item_CateInsert(account,item_category);
                System.out.print("Item_Category Table add " +item_category.getItemsId()+ "  " +item_category.getItemsId());
                isSuccess(insertRow);
            }
        }
        return -200;
    }

    /*sub function*/
    public static void Fwrite(String FILENAME,Workbook workbook) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(PATH + FILENAME, true);
        workbook.write(outputStream);
        System.out.println("Excel file Write in success！"+ PATH + FILENAME);

    }

    public static Integer check(Account account){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        IUserDAO mapper = sqlSession.getMapper(IUserDAO.class);
        return mapper.getByOId(account.getOId()).getStatus();
    }

    public static boolean Fishave(String FILENAME, Path filePath){
        if (!Files.exists(filePath)) {
            return false;
        }else {
            return true;
        }
    }

    public static void isSuccess(long insertRow){
        if(insertRow>0){
            System.out.println(" successfully !");
        }else {
            System.out.println(" ERROR ! return row number is "+insertRow);
        }
    }

    public static String turnString(Cell cell){
        CellType cellType = cell.getCellType();
        String cellValue;
        if (cellType == CellType.STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cellType == CellType.NUMERIC) {
            cellValue = String.valueOf(cell.getNumericCellValue());
        }else if (cellType == CellType.BLANK) {
            cellValue = "";
        }else {
            cellValue = "";
        }
        return  cellValue;
    }

    public static Integer dataOut(Account account,String choice) throws IOException {
        switch (choice){
            case "user": return userIn(account);
            case "item": return itemIn(account);
            case "order":return orderIn(account);
            case "cate": return cateIn(account);
            case "item-cate":return ICIn(account);
            case "user-item":return UIIn(account);
            default:return -404;
        }
    }

}



