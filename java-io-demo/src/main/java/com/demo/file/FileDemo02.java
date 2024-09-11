package com.demo.file;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * File常用方法
 */
public class FileDemo02 {
    public static void main(String[] args) {
        // 1. 创建文件
        File file = new File("java-io-demo/src/main/resources/abc.txt");
        // 2. 文件是否存在
        System.out.println(file.exists());
        // 3. 对象是否为文件
        System.out.println(file.isFile());
        // 4. 对象是否为目录
        System.out.println(file.isDirectory());
        // 5. 获取文件名称（包括后缀）
        System.out.println(file.getName());
        // 6. 返回文件字节数（目录仅返回目录本身字节数）
        System.out.println(file.length());
        // 7. 获取文件最后修改时间戳
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneOffset.ofHours(8)));
        // 8. 获取创建文件对象时使用的路径
        System.out.println(file.getPath());
        // 9. 获取绝对路径
        System.out.println(file.getAbsolutePath());
    }
}
