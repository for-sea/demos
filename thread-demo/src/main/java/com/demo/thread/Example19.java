package com.demo.thread;

import java.util.concurrent.CompletableFuture;

public class Example19 {
    public static void main(String[] args) {
        // 1. 创建第一个线程，执行1到5相加运算
        CompletableFuture<Integer> completableFuture01 = CompletableFuture.supplyAsync(() -> {
            int sum = 0, i = 0;
            while (i++ < 5) {
                sum += i;
                // 显示线程任务执行过程
                System.out.println(Thread.currentThread().getName() + "线程任务正在执行...i: " + i);
            }
            return sum;
        });
        // 创建第二个线程，执行6到10相加运算
        CompletableFuture<Integer> completableFuture02 = CompletableFuture.supplyAsync(() -> {
            int sum = 0, j = 5;
            while (j++ < 10) {
                sum += j;
                // 显示线程任务执行过程
                System.out.println(Thread.currentThread().getName() + "线程任务正在执行...j: " + j);
            }
            return sum;
        });
        // 2. 将两个线程执行结果进行获取整合
        CompletableFuture<Integer> completableFuture3 = completableFuture01.thenCombine(completableFuture02, (result1, result2) -> result1 + result2);
        System.out.println("1到10相加的结果为: " + completableFuture3);
    }
}
