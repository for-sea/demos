package com.demo.thread;

import java.util.Objects;

class SaleThread2 implements Runnable {
    private int tickets = 10; // 10张票
    Object lock = new Object(); // 定义任意一个对象，作为同步代码块的锁
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在发售第" + tickets-- + "张票");
                }
            }
        }
    }
}
public class Example12 {
    public static void main(String[] args) {
        SaleThread2 saleThread2 = new SaleThread2();
        new Thread(saleThread2, "窗口1").start();
        new Thread(saleThread2, "窗口2").start();
        new Thread(saleThread2, "窗口3").start();
        new Thread(saleThread2, "窗口4").start();
    }
}
