package com.As.service;

import java.util.Scanner;

public class OWindows {
    public static void OOutln(String text){
        System.out.println(text);
    }

    public static void OOut(String text){
        System.out.print(text);
    }

    public static String ONextLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String ONext(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static Integer ONextInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Double ONextDouble(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

}
