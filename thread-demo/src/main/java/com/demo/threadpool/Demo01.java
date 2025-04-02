package com.demo.threadpool;

import java.util.concurrent.*;

public class Demo01 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 8,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        MyRunnable myRunnable = new MyRunnable();
        // 线程池创建三个工作线程，自动处理任务
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        // 接下来三个任务存储到任务队列中
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        // 超出任务队列存储长度的任务，创建临时线程来处理，设置最多创建2个临时线程
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        // 超出任务队列存储长度的任务，且临时线程数量已满，则拒绝任务，抛出异常
        pool.execute(myRunnable);
        // 此时线程池中的工作线程数量为3，任务队列中存储的任务数量为3，临时线程数量为0，工作线程继续处理任务队列中的任务

        // pool.shutdown();    // 等待线程执行完任务，再关闭线程池
        // pool.shutdownNow(); // 无论线程是否执行完任务，立刻关闭线程池
    }
}
