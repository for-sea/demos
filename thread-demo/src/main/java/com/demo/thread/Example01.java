package com.demo.thread;

/**
 * 定义一个继承Thread类的子类
 */
class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    /**
     * 重写Thread的run()方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 的run()方法在运行。");
        }
    }
}
public class Example01 {
    public static void main(String[] args) {
        // 创建MyThread示例对象，并调用start()方法启动
        MyThread1 thread01 = new MyThread1("thread01");
        thread01.start();
        MyThread1 thread02 = new MyThread1("thread02");
        thread02.start();
    }
}
