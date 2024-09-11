package com.demo.io;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Java的编码、解码操作
 */
public class CodingDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "a我b";
        // 1. 编码
        byte[] bytes1 = str.getBytes(); // 默认用平台字符集（UTF-8）编码
        byte[] bytes2 = str.getBytes("GBK"); // 指定字符集编码
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
        // 2. 解码
        String s1 = new String(bytes1); // 默认用平台字符集（UTF-8）解码
        String s2 = new String(bytes2, "GBK"); // 指定字符集解码
        System.out.println(s1);
        System.out.println(s2);
    }
}
