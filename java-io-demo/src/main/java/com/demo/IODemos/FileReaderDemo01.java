package com.demo.IODemos;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 文件字符输入流：read方法
 */
public class FileReaderDemo01 {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("java-io-demo/src/main/java/com/demo/abc.txt")){
            // 1. 读取单个字符
            /*int c;
            // read方法返回单个字符的字节码
            while ((c = reader.read()) != -1) {
                System.out.println((char) c);
            }*/

            // 2. 读取多个字符
            char[] buffer = new char[3];
            int len;
            // read方法返回读取的字符个数
            while ((len = reader.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
