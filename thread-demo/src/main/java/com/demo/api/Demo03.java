package com.demo.api;

public class Demo03 {
    public static void main(String[] args) {
        // 创建一个账户，余额为100000元
        Account account = new Account("ICBC-118", 100000.0);
        // A与B同时对同一账户进行取款
        new Thread(new DrawMoneyTask(account, 100000.0), "A").start();
        new Thread(new DrawMoneyTask(account, 100000.0), "B").start();
    }
}
