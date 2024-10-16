package com.demo.io;

import java.io.*;

/**
 * 字节缓冲流
 */
public class BufferedDemo01 {
    public static void main(String[] args) {
        try (
                InputStream fileInputStream = new FileInputStream("java-io-demo/src/main/resources/abc.txt");
                OutputStream fileOutputStream = new FileOutputStream("java-io-demo/src/main/resources/abc.txt", true);
                InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ){
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
