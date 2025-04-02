package com.demo.api;

public class Demo01 {
    public static void main(String[] args) {
        // 创建第一个线程，设置名称，并执行任务，打印线程的名称
        Thread thread1 = new Thread(new MyThread01(), "线程1");
        thread1.start();
        System.out.println(thread1.getName());
        // 创建第二个线程，设置名称，并执行任务，打印线程的名称
        Thread thread2 = new Thread(new MyThread01(), "线程2");
        thread2.start();
        System.out.println(thread2.getName());
        // 获取当前线程（主线程），设置名称，并打印线程的名称
        Thread main = Thread.currentThread();
        main.setName("主线程");
        System.out.println(main.getName());
        for (int i = 0; i < 5; i++) {
            System.out.println(main.getName() + "输出：" + i);
        }
    }
}
