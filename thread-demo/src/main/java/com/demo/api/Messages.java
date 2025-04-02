package com.demo.api;

import java.util.ArrayList;
import java.util.List;

public class Messages {
    List<String> messages = new ArrayList<>();


    /**
     * 生产数据
     */
    public synchronized void product() {
        try {
            String name = Thread.currentThread().getName();
            // 如果消息队列为空，则生产数据，否则等待
            if (messages.isEmpty()) {
                messages.add(name + "生产的数据");
                System.out.println(name + "生产了一个数据");
                Thread.sleep(2000);
            }
            // 唤醒所有等待的线程，当前线程继续等待
            this.notifyAll();
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 消费数据
     */
    public synchronized void consume() {
        try {
            String name = Thread.currentThread().getName();
            // 如果消息队列不为空，则消费数据，否则等待
            if (!messages.isEmpty()) {
                String removed = messages.remove(0);
                System.out.println(name + "消费了一个数据：" + removed);
                Thread.sleep(2000);
            }
            // 唤醒所有等待的线程，当前线程继续等待
            this.notifyAll();
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
