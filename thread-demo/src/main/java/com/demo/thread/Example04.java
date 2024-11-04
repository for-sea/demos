package com.demo.thread;

/**
 * 定义一个继承Thread的子类
 */
class TicketWindow extends Thread {
    private int tickets = 100;
    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "正在发售第" + tickets-- + "张票");
            }
        }
    }
}
public class Example04 {
    public static void main(String[] args) {
        // 分别建立4个线程对象并开启，模拟4个售票窗口
        new TicketWindow().start();
        new TicketWindow().start();
        new TicketWindow().start();
        new TicketWindow().start();
    }
}
