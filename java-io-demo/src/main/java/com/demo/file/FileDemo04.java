package com.demo.file;

import java.io.File;

/**
 * File遍历文件
 */
public class FileDemo04 {
    public static void main(String[] args) {
        File file = new File("D:\\Document");
        // 1. 获取文件夹下的一级文件名称
        String[] list = file.list();
        for (String fileName : list) {
            System.out.println(fileName);
        }
        // 2. 获取文件夹下的一级文件对象
        File[] files = file.listFiles();
        for (File subFile : files) {
            System.out.println(subFile.getAbsolutePath());
        }
    }
}
