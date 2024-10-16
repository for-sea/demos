package com.demo.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件字节输出流
 */
public class FileOutputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        // 1. 创建一个文件字节输出流，若文件不存在会自动创建
        // 覆盖型管道
        // OutputStream outputStream = new FileOutputStream("java-io-demo/src/main/resources/output.txt");
        // 追加型管道
        OutputStream outputStream = new FileOutputStream("java-io-demo/src/main/resources/output.txt", true);

        // 2. 写入字节
        // 每次写入一个字节
        outputStream.write(97); // 表示'a'的字节码
        outputStream.write('b');
        outputStream.write('海'); // 只写入一个字节，但UTF-8的汉字有3个字节
        // 每次写入多个字节
        String str = "黑神话：悟空 Black Myth: Wukong";
        byte[] bytes = str.getBytes();
        outputStream.write(bytes);  // 全部写入
        outputStream.write(bytes, 0, 18);   // 部分写入
        outputStream.write("\r\n".getBytes()); // 换行符
        outputStream.close();
    }
}
