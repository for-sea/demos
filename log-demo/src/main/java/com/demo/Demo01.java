package com.demo;

import org.slf4j.Logger;

/**
 * Hello world!
 */
public class Demo01 {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Demo01.class);
    public static void main(String[] args) {
        try {
            logger.info("--> divide方法开始执行");
            divide(1, 0);
            logger.info("--> divide方法执行结束");
        } catch (Exception e) {
            logger.error("--> divide方法执行异常", e);
        }
    }

    public static void divide(int a, int b) {
        logger.debug("--> a = {}", a);
        logger.debug("--> b = {}", b);
        int c = a / b;
        logger.debug("--> c = {}", c);
    }
}
