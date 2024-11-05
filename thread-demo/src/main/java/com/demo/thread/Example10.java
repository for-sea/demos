package com.demo.thread;

class EmergencyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "输入: " + i);
        }
    }
}
public class Example10 {
    public static void main(String[] args) throws InterruptedException {
        // 创建并开启线程
        EmergencyThread emergencyThread = new EmergencyThread();
        Thread thread01 = new Thread(emergencyThread, "thread01");
        thread01.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "输入: " + i);
            if (i == 2) {
                thread01.join(); // 调用join方法
            }
        }
    }
}
