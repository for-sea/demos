package com.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 校验用户输入的电话、邮箱、时间是否合法
 */
public class Demo1 {
    public static void main(String[] args) {
        // checkPhone();
        // checkEmail();
        checkTime();
    }

    // 校验用户输入的电话是否合法
    public static void checkPhone() {
        System.out.println("请输入您的号码：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 匹配手机号或座机号
        // 手机号：一共十一位，1开头，第二位3-9，后面九位任意数字，如 13712345678
        // 座机号：区号-座机号码，区号0开头，三到八位，座机号1-9开头，五到二十位，如 012-123456
        if (str.matches("(1[3-9]\\d{9})|(0\\d{2,7}-?[1-9]\\d{4,19})")) {
            System.out.println("您输入的号码正确");
        } else {
            System.out.println("您输入的号码不正确");
        }
    }

    // 校验用户输入的邮箱是否合法
    public static void checkEmail() {
        System.out.println("请输入您的邮箱：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 匹配邮箱
        // 258741369@qq.com
        // forsea@163.com
        // forsea.xiao@gmail.com
        // dorsea.xiao@foxmail.com.cn
        if (str.matches("\\w{2,}(\\.\\w{2,})?@\\w{2,20}(\\.\\w{2,10}){1,2}")) {
            System.out.println("您输入的邮箱正确");
        } else {
            System.out.println("您输入的邮箱不正确");
        }
    }

    // 校验用户输入的时间是否合法
    public static void checkTime() {
        System.out.println("请输入您的时间：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 匹配时间
        // yyyy-MM-dd HH:mm:ss，仅考虑格式，不考虑时间有效性，可以使用LocalDateTime进行时间有效性验证
        if (str.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            try {
                LocalDateTime.parse(str, dateTimeFormatter);
                System.out.println("您输入的时间正确");
            } catch (Exception e) {
                System.out.println("您输入的时间不正确");
            }

        } else {
            System.out.println("您输入的时间不正确");
        }
    }
}
