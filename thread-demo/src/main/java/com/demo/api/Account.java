package com.demo.api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 账户
 */
public class Account {
    /**
     * 卡号
     */
    private String cardId;

    /**
     * 余额
     */
    private Double money;


    /**
     * 锁对象
     */
    private final Lock lock = new ReentrantLock();

    public Account(String cardId, Double balance) {
        this.cardId = cardId;
        this.money = balance;
    }

    /**
     * 取款逻辑
     * @param money
     */
    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        try {
            lock.lock();    // 加锁
            if (this.money >= money) {  // 余额充足
                System.out.println(name + "取款" + money + "元");
                // 模拟取款，扣除余额
                this.money -= money;
                System.out.println(name + "取款成功，取款后余额为：" + this.money);
            } else {    // 余额不足
                System.out.println(name + "取款失败，余额不足");
            }
        } finally {
            lock.unlock();  // 解锁
        }
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
