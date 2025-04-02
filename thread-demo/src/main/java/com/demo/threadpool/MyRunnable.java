package com.demo.threadpool;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "输出：六百六十六");
        try {
            Thread.sleep(2020);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
