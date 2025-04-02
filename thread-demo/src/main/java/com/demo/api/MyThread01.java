package com.demo.api;

public class MyThread01 implements Runnable{
    @Override
    public void run() {
        // 获取当前线程
        Thread thread = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println(thread.getName() + "线程输出：" + i);
        }
    }
}
