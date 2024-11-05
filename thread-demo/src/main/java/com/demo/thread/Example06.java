package com.demo.thread;

class DaemonThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "---在运行");
        }
    }
}
public class Example06 {
    public static void main(String[] args) {
        // 判断是否为后台线程
        System.out.println("main线程是后台线程吗？" + Thread.currentThread().isDaemon());
        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread, "后台线程");
        System.out.println("thread线程默认是后台线程吗？" + thread.isDaemon());
        // 将thread线程对象设置为后台线程
        thread.setDaemon(true);
        thread.start();
        // 模拟主线程main的执行任务
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}
