package com.demo.thread;

public class Example08 {
    public static void main(String[] args) {
        // 分别定义两个Thread对象
        Thread thread01 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "正在输出i: " + i);
                if (i == 2) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread02 = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + "正在输出j: " + j);
            }
        });
        thread01.start();
        thread02.start();
    }
}
