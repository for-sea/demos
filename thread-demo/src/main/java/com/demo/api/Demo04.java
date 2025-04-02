package com.demo.api;

public class Demo04 {
    public static void main(String[] args) {
        // 创建消息对象
        Messages messages = new Messages();
        // 创建并启动三个生产者线程和两个消费者线程
        new Thread(() -> {
            while (true) {
                messages.product();
            }
        }, "生产者1").start();
        new Thread(() -> {
            while (true) {
                messages.product();
            }
        }, "生产者2").start();
        new Thread(() -> {
            while (true) {
                messages.product();
            }
        }, "生产者3").start();
        new Thread(() -> {
            while (true) {
                messages.consume();
            }
        }, "消费者1").start();
        new Thread(() -> {
            while (true) {
                messages.consume();
            }
        }, "消费者2").start();
    }
}
