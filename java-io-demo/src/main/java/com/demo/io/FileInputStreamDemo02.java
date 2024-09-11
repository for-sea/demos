package com.demo.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流：每次读取多个字节
 */
public class FileInputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        // 1. 创建文件字节输入流管道
        InputStream inputStream = new FileInputStream("java-io-demo/src/main/resources/abc.txt");
        // 2. 创建缓存
        byte[] buffer = new byte[3];
        /*// 3. 每次读取多个字节，存入缓存
        int length = inputStream.read(buffer);
        String str = new String(buffer);
        System.out.println("当前读取的字节数量：" + length);
        System.out.println(str);

        // 4. 之后读取的字节会覆盖缓存中原来的字节，但是会出现后面的长度不足以覆盖缓存的字节的情况
        int length2 = inputStream.read(buffer);
        // 5. 读取多少个字节就解码多少个字节
        String str2 = new String(buffer, 0, length2);
        System.out.println("当前读取的字节数量：" + length2);
        System.out.println(str2);*/

        // 3. 循环读取字节
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, length));
        }
        inputStream.close();
    }
}
