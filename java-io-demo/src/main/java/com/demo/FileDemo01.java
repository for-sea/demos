package com.demo;

import java.io.File;

/**
 * File对象构造
 */
public class FileDemo01 {
    public static void main(String[] args) {
        // 1. 创建File对象（构造器）
        // File file = new File("D:/Document/temp/demo.txt");
        // File file = new File("D:\\Document\\temp\\demo.txt");
        // File file = new File("D:" + File.separator + "Document" + File.separator + "temp" + File.separator + "demo.txt");

        // 2. 绝对路径与相对路径
        // File file = new File("D:\\Code\\privatespace\\demos\\java-io-demo\\src\\main\\java\\com\\demo\\abc.txt");
        File file = new File("java-io-demo/src/main/java/com/demo/abc.txt");
        System.out.println(file.getPath());
        System.out.println(file.length());
    }
}
