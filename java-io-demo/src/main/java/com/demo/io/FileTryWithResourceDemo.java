package com.demo.io;

import java.io.*;

/**
 * try-with-resource 释放资源方案
 */
public class FileTryWithResourceDemo {
    public static void main(String[] args) {
        try (// 文件字节输入流
             InputStream inputStream = new FileInputStream("java-io-demo/src/main/resources/pic.jpg");
             // 文件字节输出流
             OutputStream outputStream = new FileOutputStream("java-io-demo/src/main/resources/pic-copy.jpg")
        ) {
            // 缓冲字节数组 1kb
            byte[] buffer = new byte[1024];
            // 输入流读取的字节长度
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                // 输出流写入缓冲字节数组中的数据
                outputStream.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
