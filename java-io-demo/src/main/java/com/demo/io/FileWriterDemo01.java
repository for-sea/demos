package com.demo.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件字符输出流
 */
public class FileWriterDemo01 {
    public static void main(String[] args) {
        // 创建文件字符输出流
        // Writer writer = new FileWriter("java-io-demo/src/main/resources/abc-copt.txt") // 覆盖型写入
        try (Writer writer = new FileWriter("java-io-demo/src/main/resources/abc-copt.txt", true)) {
            // 1. 写一个字符
            writer.write(97);
            writer.write('b');
            writer.write('海');
            writer.write("\r\n");
            // 2. 写一个字符串
            String str = "要做神仙，驾鹤飞天。点石成金，妙不可言。";
            writer.write(str);
            writer.write("\r\n");
            // 3. 写字符串的一部分
            writer.write(str, 0, 10);
            writer.write("\r\n");
            // 4. 写一个字符数组
            char[] buffer = {'春', '眠', '不', '觉', '晓'};
            writer.write(buffer);
            writer.write("\r\n");
            // 5. 写字符数组的一部分
            writer.write(buffer, 0, 3);
            writer.write("\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
