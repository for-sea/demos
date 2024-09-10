package com.demo.IODemos;

import java.io.*;

/**
 * 拷贝文件
 */
public class FileCopyDemo {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 文件字节输入流
            inputStream = new FileInputStream("java-io-demo/src/main/java/com/demo/pic.jpg");
            // 文件字节输出流
            outputStream = new FileOutputStream("java-io-demo/src/main/java/com/demo/pic-copy.jpg");
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
        } finally {
            // 关闭输入输出流
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
