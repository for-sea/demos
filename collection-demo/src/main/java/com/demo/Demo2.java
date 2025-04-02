package com.demo;

import java.util.LinkedList;

public class Demo2 {
    public static void main(String[] args) {
        // 创建队列
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("张三");
        queue.addLast("李四");
        queue.addLast("王五");
        queue.addLast("赵六");
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        // 创建栈
        LinkedList<String> stack = new LinkedList<>();
        stack.addFirst("1号");
        stack.addFirst("2号");
        stack.addFirst("3号");
        stack.addFirst("4号");
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
    }
}
