package com.demo.threadpool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return name + "线程执行完毕，结果为：" + sum;
    }
}
