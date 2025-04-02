package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("张三", "李四", "王五", "赵六"));
        // 1. 匿名内部类
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 2. Lambda表达式
        list.forEach((String s) -> {
            System.out.println(s);
        });
        // 3. Lambda表达式简化
        list.forEach(s -> System.out.println(s));
        // 4. 方法引用
        list.forEach(System.out::println);
    }
}
