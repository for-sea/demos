package com.demo.thread;

import java.util.concurrent.*;

// 1、定义一个实现Callable接口的实现类
class MyThread4 implements Callable<Object> {
    // 1.1、重写Callable接口的call()方法
    @Override
    public Object call() throws Exception {
        int i = 0;
        while (i++ < 5) {
            System.out.println(Thread.currentThread().getName() + "的call()方法在运行");
        }
        return i;
    }
}
public class Example18 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 2. 创建Callable接口的实现类对象
        MyThread4 myThread4 = new MyThread4();
        // 3. 使用Executors线程执行器类创建可扩展的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 4. 将Callable接口实现类对象提交到线程池进行管理
        Future<Object> result1 = executorService.submit(myThread4);
        Future<Object> result2 = executorService.submit(myThread4);
        // 5. 关闭线程池
        executorService.shutdown();
        // 对于有返回值的线程任务，获取执行结果
        System.out.println("thread-1的执行结果: " + result1.get());
        System.out.println("thread-2的执行结果: " + result2.get());
    }
}
