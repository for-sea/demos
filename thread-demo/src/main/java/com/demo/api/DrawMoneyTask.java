package com.demo.api;

/**
 * 取款任务
 */
public class DrawMoneyTask implements Runnable{
    /**
     * 账户
     */
    private Account account;
    /**
     * 取款金额
     */
    private double money;

    public DrawMoneyTask(Account account, double money) {
        this.account = account;
        this.money = money;
    }
    @Override
    public void run() {
        // 执行取款操作
        account.drawMoney(this.money);
    }
}
