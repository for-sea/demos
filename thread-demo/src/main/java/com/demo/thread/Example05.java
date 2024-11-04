package com.demo.thread;

class TicketWindow2 implements Runnable {
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
public class Example05 {
    public static void main(String[] args) {
        // 创建TicketWindow2实例对象
        TicketWindow2 ticketWindow2 = new TicketWindow2();
        // 分别创建4个线程并进行命名，并开启线程
        new Thread(ticketWindow2, "窗口1").start();
        new Thread(ticketWindow2, "窗口2").start();
        new Thread(ticketWindow2, "窗口3").start();
        new Thread(ticketWindow2, "窗口4").start();
    }
}
