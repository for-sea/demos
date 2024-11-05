package com.demo.thread;

class SaleThread3 implements Runnable {
    private int tickets = 10;
    @Override
    public void run() {
        while (true) {
            saleTickets();
        }
    }
    // 定义一个同步方法saleTickets()
    private synchronized void saleTickets() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "正在发售第" + tickets-- + "张票");
        }
    }
}
public class Example13 {
    public static void main(String[] args) {
        SaleThread3 saleThread3 = new SaleThread3();
        new Thread(saleThread3, "窗口1").start();
        new Thread(saleThread3, "窗口2").start();
        new Thread(saleThread3, "窗口3").start();
        new Thread(saleThread3, "窗口4").start();
    }
}
