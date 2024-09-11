package com.demo.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流：每次读取一个字节
 */
public class FileInputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        // 1. 创建文件字节输入流管道，与源文件接通
        InputStream inputStream = new FileInputStream("java-io-demo/src/main/resources/abc.txt");
        // 2. 开始读取文件字节数据
        /*int byte1 = inputStream.read();
        System.out.println((char) byte1);
        int byte2 = inputStream.read();
        System.out.println((char) byte2);
        int byte3 = inputStream.read();
        System.out.println((char) byte3);*/
        // 3. 循环读取文件字节数据
        int res;
        while ((res = inputStream.read()) != -1) {
            System.out.print((char)res);
        }

        /*
            1. 性能很差
            2. 读汉字会乱码
            3. 流使用后要关闭，释放资源
         */
        inputStream.close();
    }
}
