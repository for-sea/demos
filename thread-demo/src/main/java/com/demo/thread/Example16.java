package com.demo.thread;

import java.util.ArrayList;
import java.util.List;

public class Example16 {
    public static void main(String[] args) {
        // 定义一个集合，模拟存放生产的商品
        List<Object> goods = new ArrayList<>();
        // 记录线程执行前统一的的起始时间start
        long start = System.currentTimeMillis();
        // 创建一个生产者线程，用于生产商品并存入商品集合
        Thread thread01 = new Thread(() -> {
            int num = 0;
            while (System.currentTimeMillis() - start <= 100) {
                goods.add("商品" + ++num);
                System.out.println("生产商品" + num);
            }
        }, "生产者");
        Thread thread02 = new Thread(() -> {
            int num = 0;
            while (System.currentTimeMillis() - start <= 100) {
                goods.remove("商品" + ++num);
                System.out.println("消费商品" + num);
            }
        }, "消费者");
        // 同时启动生产者和消费者两个线程，并统一执行100毫秒的时间
        thread01.start();
        thread02.start();
    }
}
