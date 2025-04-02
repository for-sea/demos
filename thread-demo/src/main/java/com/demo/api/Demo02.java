package com.demo.api;

public class Demo02 {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                // 线程休眠5秒
                Thread.sleep(5000);
            }
            System.out.println("输出" + i);
        }
        // 线程1、2、3分别启动，按顺序执行
        Thread thread1 = new Thread(new MyThread01(), "线程1");
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(new MyThread01(), "线程2");
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(new MyThread01(), "线程3");
        thread3.start();
        thread3.join();
    }
}
