package com.demo.io;

import java.io.*;

/**
 * 字符转换流：解决文件与代码使用的字符集不同的问题
 */
public class StreamReaderDemo01 {
    public static void main(String[] args) {
        try (
                // 字节输入流 -> 字符输入转换流 -> 字符输入缓冲流
                InputStream inputStream = new FileInputStream("java-io-demo/src/main/resources/abc-gbk.txt");
                Reader inputStreamReader = new InputStreamReader(inputStream, "GBK");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                // 字节输出流 -> 字符输出转换流 -> 字符输出缓冲流
                OutputStream outputStream = new FileOutputStream("java-io-demo/src/main/resources/abc-gbk.txt", true);
                Writer outputStreamWriter = new OutputStreamWriter(outputStream, "GBK");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.newLine();
                bufferedWriter.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
