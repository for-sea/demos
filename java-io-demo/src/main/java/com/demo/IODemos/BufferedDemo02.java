package com.demo.IODemos;

import java.io.*;

/**
 * 字符缓冲流
 */
public class BufferedDemo02 {
    public static void main(String[] args) {
        try (
                Reader reader = new FileReader("java-io-demo/src/main/java/com/demo/abc.txt");
                Writer writer = new FileWriter("java-io-demo/src/main/java/com/demo/abc.txt", true);
                BufferedReader bufferedReader = new BufferedReader(reader);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
