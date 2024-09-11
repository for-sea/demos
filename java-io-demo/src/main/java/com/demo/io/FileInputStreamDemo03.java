package com.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流：一次读取所有字节
 */
public class FileInputStreamDemo03 {
    public static void main(String[] args) throws IOException {
        // 1. 创建文件字节输入流管道
        File file = new File("java-io-demo/src/main/resources/abc.txt");
        InputStream inputStream = new FileInputStream(file);
        // 2. 创建大小与文件字节长度一样的缓冲字节数组
        long length = file.length();
        byte[] buffer = new byte[(int) length];
        // 3. 读取所有字节，并解码
        int readLength = inputStream.read(buffer);
        System.out.println("缓冲字节数组长度：" + buffer.length);
        System.out.println("读取字节字节长度：" + readLength);
        System.out.println("读取字节解码内容：" + new String(buffer));
    }
}
