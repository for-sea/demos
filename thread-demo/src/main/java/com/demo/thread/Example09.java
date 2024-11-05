package com.demo.thread;

class YieldThread extends Thread {
    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            if (i == 2) {
                System.out.println("线程让步: ");
                Thread.yield();
            }
        }
    }
}
public class Example09 {
    public static void main(String[] args) {
        // 创建两个线程
        Thread thread01 = new YieldThread("thread01");
        Thread thread02 = new YieldThread("thread02");
        // 开启两个线程
        thread01.start();
        thread02.start();
    }

}
