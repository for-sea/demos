package com.demo.thread;

/**
 * 实现Runnable接口，重写run()方法
 */
class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 的run()方法在运行。");
        }
    }
}
public class Example02 {
    public static void main(String[] args) {
        // 创建Runnable接口实现类的实例
        MyThread2 myThread2 = new MyThread2();
        // 使用Thread(Runnable target, String name)构造方法创建线程对象
        Thread thread01 = new Thread(myThread2, "thread01");
        thread01.start();
        Thread thread02 = new Thread(myThread2, "thread02");
        thread02.start();
    }
}
