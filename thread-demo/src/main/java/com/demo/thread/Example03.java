package com.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable的run()方法，方法有返回值
 */
class MyThread3 implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " 的run()方法在运行。");
        }
        return "call()方法执行完毕";
    }
}
public class Example03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable的实现类对象
        MyThread3 myThread3 = new MyThread3();
        // 使用FutureTask封装Callable接口
        FutureTask<Object> futureTask01 = new FutureTask<>(myThread3);
        // 使用Thread(Runnable target ,String name)构造方法创建线程对象
        Thread thread01 = new Thread(futureTask01, "thread01");
        thread01.start();
        FutureTask<Object> futureTask02 = new FutureTask<>(myThread3);
        Thread thread02 = new Thread(futureTask02, "thread02");
        thread02.start();
        System.out.println("thread01返回结果：" + futureTask01.get());
        System.out.println("thread02返回结果：" + futureTask02.get());
    }
}
