package com.demo.threadpool;

import java.util.concurrent.*;

public class Demo02 {
    public static void main(String[] args) {
        // 1. 通过ThreadPoolExecutor类创建一个线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 8,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        // 使用Executors创建一个线程池对象
        // ExecutorService pool = Executors.newFixedThreadPool(3);
        // 2. 提交任务到线程池中执行
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
