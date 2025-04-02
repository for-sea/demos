package com.demo.xml;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Demo02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<book>\r\n");
        sb.append("\t<name>").append("《Java 特殊文件处理》").append("</name>\r\n");
        sb.append("\t<author>").append("李兴").append("</author>\r\n");
        sb.append("\t<price>").append("99").append("</price>\r\n");
        sb.append("</book>");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("java-io-demo/src/main/resources/book.xml"))) {
            writer.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
