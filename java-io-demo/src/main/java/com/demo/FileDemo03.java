package com.demo;

import java.io.File;
import java.io.IOException;

/**
 * File创建文件
 */
public class FileDemo03 {
    public static void main(String[] args) throws IOException {
        // 1. 创建文件
        File file = new File("java-io-demo/src/main/java/com/demo/123.txt");
        System.out.println(file.createNewFile());
        // 2. 创建文件夹（只能创建一级文件夹）
        File directory1 = new File("java-io-demo/src/main/java/com/demo/directory");
        System.out.println(directory1.mkdir());
        // 3. 创建文件夹（创建多级文件夹）
        File directory2 = new File("java-io-demo/src/main/java/com/demo/aaa/bbb/ccc");
        System.out.println(directory2.mkdirs());
        // 4. 删除文件或空文件夹
        System.out.println(file.delete());
        System.out.println(directory1.delete());
        System.out.println(directory2.delete()); // 只能删除最下一级目录
    }
}
