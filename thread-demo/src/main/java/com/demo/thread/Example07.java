package com.demo.thread;

public class Example07 {
    public static void main(String[] args) {
        // 分别建立两个线程对象
        Thread thread01 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "正在输出i: " + i);
            }
        }, "优先级较低的线程");
        Thread thread02 = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + "正在输出j: " + j);
            }
        }, "优先级较高的线程");
        // 分别设置线程的优先级
        thread01.setPriority(Thread.MIN_PRIORITY);
        thread02.setPriority(10);
        // 开启两个线程
        thread01.start();
        thread02.start();
    }
}
