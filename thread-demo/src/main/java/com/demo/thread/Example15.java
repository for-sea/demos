package com.demo.thread;

class DeadLockThread implements Runnable {
    // 定义两个不同的锁对象
    static Object chopsticks = new Object();
    static Object knifeAndFork = new Object();
    private boolean flag;

    public DeadLockThread(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            while (true) {
                // chopsticks锁对象上的同步代码块
                synchronized (chopsticks) {
                    System.out.println(Thread.currentThread().getName() + "---if---chopsticks");
                    // knifeAndFork锁对象上的同步代码块
                    synchronized (knifeAndFork) {
                        System.out.println(Thread.currentThread().getName() + "---if---knifeAndFork");
                    }
                }
            }
        } else {
            while (true) {
                // knifeAndFork锁对象上的同步代码块
                synchronized (knifeAndFork) {
                    System.out.println(Thread.currentThread().getName() + "---else---knifeAndFork");
                    // chopsticks锁对象上的同步代码块
                    synchronized (chopsticks) {
                        System.out.println(Thread.currentThread().getName() + "---else---chopsticks");
                    }
                }
            }
        }
    }
}

public class Example15 {
    public static void main(String[] args) {
        // 创建两个DeadLockThread对象
        DeadLockThread deadLockThread1 = new DeadLockThread(true);
        DeadLockThread deadLockThread2 = new DeadLockThread(true);
        // 创建并开启两个线程
        new Thread(deadLockThread1, "Chinese").start();
        new Thread(deadLockThread2, "America").start();
    }
}

