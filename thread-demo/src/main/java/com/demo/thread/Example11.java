package com.demo.thread;

class SaleThread implements Runnable {
    private int tickets = 10; // 10张票
    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(100); // 模拟售票耗时过程
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在发售第" + tickets-- + "张票");
            }
        }
    }
}
public class Example11 {
    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();
        // 创建并开启4个线程，模拟售票窗口
        new Thread(saleThread, "窗口1").start();
        new Thread(saleThread, "窗口2").start();
        new Thread(saleThread, "窗口3").start();
        new Thread(saleThread, "窗口4").start();
    }
}
