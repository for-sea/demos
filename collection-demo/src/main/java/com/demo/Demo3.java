package com.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo3 {
    /**
     * 主函数执行程序的主要逻辑
     */
    public static void main(String[] args) {
        // 创建并初始化手机品牌价格映射
        Map<String, Integer> phonePrices = createPhonePrices();

        // 打印手机品牌及其价格
        printPhonePrices(phonePrices);
    }

    /**
     * 创建并返回一个包含手机品牌及其价格的映射
     * @return 包含手机品牌及其价格的映射
     */
    private static Map<String, Integer> createPhonePrices() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("小米", 4999);
        map.put("华为", 5999);
        map.put("苹果", 9999);
        map.put("OPPO", 3999);
        map.put("vivo", 2999);
        return map;
    }

    /**
     * 遍历并打印手机品牌及其价格
     * @param phonePrices 包含手机品牌及其价格的映射
     */
    private static void printPhonePrices(Map<String, Integer> phonePrices) {
        if (phonePrices == null || phonePrices.isEmpty()) {
            System.out.println("没有手机品牌价格信息");
            return;
        }
        phonePrices.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
