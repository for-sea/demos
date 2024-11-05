package com.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockThread implements Runnable {
    private int tickets = 10;
    private final Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            lock.lock(); // 对代码块进行加锁
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "正在发售第" + tickets-- + "张票");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock(); // 执行完代码块后释放锁
                }
            } else {
                lock.unlock();
                break;
            }
        }
    }
}
public class Example14 {
    public static void main(String[] args) {
        LockThread lockThread = new LockThread();
        new Thread(lockThread, "窗口1").start();
        new Thread(lockThread, "窗口2").start();
        new Thread(lockThread, "窗口3").start();
        new Thread(lockThread, "窗口4").start();
    }
}
